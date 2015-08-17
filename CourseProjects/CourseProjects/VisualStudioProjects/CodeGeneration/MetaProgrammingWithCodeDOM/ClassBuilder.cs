using System;
using System.CodeDom;
using System.IO;
using System.CodeDom.Compiler;
using Microsoft.CSharp;
using Microsoft.VisualBasic;

namespace UsingCodeDOM
{
	class ClassBuilder
	{
		[STAThread]
		static void Main(string[] args)
		{
			Console.WriteLine("Enter the name for your class");
			string className = Console.ReadLine();

			Console.WriteLine("\nEnter the message you want the main method to print");
			string message = Console.ReadLine();

			//A CodeCompileUnit is out reference to the object graph
			CodeCompileUnit compileUnit = createCompileUnit(className,message);

			compileCode(compileUnit);

			writeCode(compileUnit);

		}
		private static void compileCode(CodeCompileUnit compileUnit) {

			//Specify how we want our code compiled
			CompilerParameters parameters = new CompilerParameters();
			parameters.GenerateExecutable = true;
			parameters.GenerateInMemory = false;
			parameters.OutputAssembly = "CodeDOMDemoOutput.exe";

			//Compile the code
			CodeDomProvider provider = new CSharpCodeProvider();
			ICodeCompiler compiler = provider.CreateCompiler();
			CompilerResults results = compiler.CompileAssemblyFromDom(parameters,compileUnit);

			//Signal completion and display any compiler output
			Console.WriteLine("\nAssembly created and saved to: {0}",results.PathToAssembly);
			if(results.Output.Count > 0) 
			{
				Console.WriteLine("Compiler output was");
				foreach(string output in results.Output) 
				{
					Console.WriteLine("\t{0}",output);
				}
			}
		}

		private static void writeCode(CodeCompileUnit compileUnit) 
		{
			//Create a code generator that can output VB source
			CodeDomProvider provider = new VBCodeProvider();
			ICodeGenerator generator = provider.CreateGenerator();

			//Default options are file
			CodeGeneratorOptions options = new CodeGeneratorOptions();

			//Keep the output in memory
			StringWriter output = new StringWriter();

			//Build the code and display it
			generator.GenerateCodeFromCompileUnit(compileUnit,output,options);
			Console.WriteLine("\nThe following VB source was generated\n\n");
			Console.WriteLine(output.ToString());
		}

		private static CodeCompileUnit createCompileUnit(string className,string message) 
		{
			//Create a namespace for our code to live in
			CodeNamespace demoNamespace = new CodeNamespace("Demos.CodeDOM");

			//Add a class to our namespace
			CodeTypeDeclaration classDeclaration = new CodeTypeDeclaration(className);
			demoNamespace.Types.Add(classDeclaration);

			//Declare a main method
			CodeEntryPointMethod mainMethod = new CodeEntryPointMethod();
			CodeTypeReferenceExpression codeRef = new CodeTypeReferenceExpression("System.Console");
			CodeMethodInvokeExpression  line1 = new CodeMethodInvokeExpression( codeRef, "WriteLine", new CodePrimitiveExpression(message) );
			mainMethod.Statements.Add(new CodeExpressionStatement(line1));

			//Add the main method to the class
			classDeclaration.Members.Add(mainMethod);

			//Create the object graph
			CodeCompileUnit compileUnit = new CodeCompileUnit();
			compileUnit.Namespaces.Add(demoNamespace);

			return compileUnit;
		}
	}
}
