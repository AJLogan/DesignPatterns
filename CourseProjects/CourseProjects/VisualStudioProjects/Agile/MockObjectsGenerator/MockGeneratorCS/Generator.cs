using System;
using System.Collections;
using System.IO;
using System.Reflection;
using System.CodeDom;
using System.CodeDom.Compiler;
using Microsoft.CSharp;
using Microsoft.VisualBasic;

namespace MockGenerator {
	class Generator {
		public Generator (string assemblyFileName) {
			//Load the assembly as a binary file
			FileInfo file = new FileInfo(assemblyFileName);
			BinaryReader reader = new BinaryReader(file.Open(FileMode.Open));
			byte[] rawAssembly = reader.ReadBytes((int)file.Length);

			//Get the current AppDomain and load the assembly into it
			AppDomain current = AppDomain.CurrentDomain;
			targetAssembly = current.Load(rawAssembly);
		}
		public void buildMockClass(string targetClassName, string mockClassName, IList strategies) {
			foreach(Type t in targetAssembly.GetExportedTypes()) {
				if(t.FullName.Equals(targetClassName)) {
					targetClass = t;
				}
			}
			//Create a namespace for our mock to live in
			CodeNamespace nspace = new CodeNamespace(targetClass.Namespace);

			//Create the mock class
			CodeTypeDeclaration klass = new CodeTypeDeclaration(mockClassName);
			//Make the mock inherit from the same class as the original
			klass.BaseTypes.Add(targetClass.BaseType);
			//Add the class to our namespace
			nspace.Types.Add(klass);

			MethodInfo[] methods = targetClass.GetMethods();

			foreach(MethodInfo m in methods) {
				//ignore methods defined in the base class
				if(targetClass == m.DeclaringType) {
					addMethodToMockClass(m,klass);
				}
			}
			foreach(Strategy strategy in strategies) {
				strategy.apply(klass,targetClass);
			}

			//Create the object graph
			compileUnit = new CodeCompileUnit();
			compileUnit.Namespaces.Add(nspace);
		}
		private void addMethodToMockClass(MethodInfo method, CodeTypeDeclaration klass) {
			CodeMemberMethod newMethod = new CodeMemberMethod();
			newMethod.Name = method.Name;
			newMethod.Attributes = MemberAttributes.Public | MemberAttributes.Final;
			newMethod.ReturnType = new CodeTypeReference(method.ReturnType.FullName);
			foreach(ParameterInfo p in method.GetParameters()) {
				newMethod.Parameters.Add(new CodeParameterDeclarationExpression(p.ParameterType.FullName,p.Name));
			}
			if(returnStatementRequired(method)) {
				newMethod.Statements.Add(buildReturnStatement(method.ReturnType));
			}
			klass.Members.Add(newMethod);
		}
		public void writeCodeAsVB(StreamWriter sw) {
			writeCode(new VBCodeProvider(),sw);
		}
		public void writeCodeAsCSharp(StreamWriter sw) {
			writeCode(new CSharpCodeProvider(),sw);
		}
		private void writeCode(CodeDomProvider provider,StreamWriter sw) {
			//Create a code generator
			ICodeGenerator generator = provider.CreateGenerator();

			//Default options are fine
			CodeGeneratorOptions options = new CodeGeneratorOptions();

			//Build the code and display it
			generator.GenerateCodeFromCompileUnit(compileUnit,sw,options);

			sw.Flush();
		}
		private bool returnStatementRequired(MethodInfo method) {
			return !method.ReturnType.FullName.Equals("System.Void");
		}
		private CodeMethodReturnStatement buildReturnStatement(Type returnType) {
			CodePrimitiveExpression ex;
			if(returnType.FullName.Equals("System.Boolean")) {
				ex = new CodePrimitiveExpression(false);
			} else if(returnType.IsPrimitive) {
				ex = new CodePrimitiveExpression(0);
			} else {
				ex = new CodePrimitiveExpression(null);
			}
			return new CodeMethodReturnStatement(ex);
		}
		public Assembly assembly {
			get {
				return targetAssembly;
			}
		}
		private Type targetClass;
		private Assembly targetAssembly;
		private CodeCompileUnit compileUnit;
	}
}
