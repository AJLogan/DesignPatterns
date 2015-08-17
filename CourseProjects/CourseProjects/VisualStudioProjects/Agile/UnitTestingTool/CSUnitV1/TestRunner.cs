using System;
using System.Collections;
using System.Reflection;

using System.Windows.Forms;

namespace CSUnitV1 {

	public class TestRunner {
		public TestRunner() {
			//Get the application domain for the current thread
			currentAppDomain = AppDomain.CurrentDomain;
			//Create the list of previous assemblies
			previouslyTestedAssemblies = new ArrayList();
		}
		//Allow access to the assemblies we have already tested
		public Assembly[] testedAssemblies {
			get {
				//return the list as an array
				return (Assembly[]) previouslyTestedAssemblies.ToArray(typeof(Assembly));
			}
			set {
				//replace the old list with a new one
				previouslyTestedAssemblies = new ArrayList();
				foreach(Assembly assembly in value) {
					previouslyTestedAssemblies.Add(assembly);
				}
			}
		}
		//Allow access to assembly under test
		public byte[] assembly {
			set {
				//When we set a new assembly add it to the list
				assemblyBeingTested = getAssembly(value);
				previouslyTestedAssemblies.Add(assemblyBeingTested);
			}
		}
		//View all the available types in the test assembly
		public Type[] typesInAssembly {
			get {
				//Return the list of available types
				return assemblyBeingTested.GetExportedTypes();
			}
		}
		//Allow access to the type to be tested
		public Type testClass {
			get {
				return typeBeingTested;
			}
			set {
				typeBeingTested = value;
			}
		}
		//Allow access to all the test methods of the current test class
		public MethodInfo[] testMethods {
			get {
				ArrayList testMethods = new ArrayList();
				MethodInfo[] methods = typeBeingTested.GetMethods();
				foreach(MethodInfo method in methods) {
					//MessageBox.Show(method.Name);
					if(method.Name.StartsWith("test")) {
						if(method.GetParameters().Length == 0) {
							testMethods.Add(method);
						}
					}
				}
				return (MethodInfo[])testMethods.ToArray(typeof(MethodInfo));
			}
		}
		//A delegate to represent a callback used when running multiple test methods
		public delegate void TestUpdate();

		//Run all the test methods of the current test type
		public TestResult[] runAllTestMethods(TestUpdate update) {
			ArrayList results = new ArrayList();
			object instance = createInstanceOfTestType();
			foreach(MethodInfo method in testMethods) {
				Exception current = null;
				bool result = true;
				try {
					method.Invoke(instance,null);
				} catch(TargetInvocationException ex) {
					current = ex.InnerException;
					result = false;
				} finally {
					results.Add(new TestResult(method,result,current));
					update();
				}
			}
			return (TestResult[])results.ToArray(typeof(TestResult));
		}

		//run a single test method
		public TestResult runSingleTestMethod(string methodName) {
			object instance = createInstanceOfTestType();
			MethodInfo method = typeBeingTested.GetMethod(methodName, new Type[0]);
			Exception current = null;
			bool result = true;
			try {
				method.Invoke(instance,null);
			} catch(TargetInvocationException ex) {
				current = ex.InnerException;
				result = false;
			} 
			return new TestResult(method,result,current);
		}

		//Get and invoke the no-args constructor of our test type
		private object createInstanceOfTestType() {
			ConstructorInfo defaultConstructor = typeBeingTested.GetConstructor(new Type[]{});
			return defaultConstructor.Invoke(null);
		}
		//Load an assembly based on its name
		private Assembly getAssembly(String assemblyName) {
			//Load the assembly into the current domain
			return currentAppDomain.Load(assemblyName);
		}
		//Create an assembly from an array of bytes
		private Assembly getAssembly(byte[] bytes) {
			//Load the assembly into the current domain
			return currentAppDomain.Load(bytes);
		}
		//The current CLR 'process'
		private AppDomain currentAppDomain;
		//The class we are testing
		private Type typeBeingTested;
		//The assembly of the test class
		private Assembly assemblyBeingTested;
		//All the assemblies we have tested to date
		private ArrayList previouslyTestedAssemblies;
	}
}
