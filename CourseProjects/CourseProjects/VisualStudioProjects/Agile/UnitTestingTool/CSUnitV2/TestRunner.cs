using System;
using System.Collections;
using System.Reflection;

namespace CSUnitV2
{
	public class TestRunner
	{
		public TestRunner(Type testClass)
		{			
			this.testClass = testClass;
		}
		//Get the names of all the tester methods
		public string[] getTestMethodNames() {
			ArrayList testMethods = new ArrayList();
			MethodInfo[] methods = testClass.GetMethods();
			foreach(MethodInfo method in methods) {
				if(method.Name.StartsWith("test")) {
					if(method.GetParameters().Length == 0) {
						testMethods.Add(method.Name);
					}
				}
			}
			return (string[])testMethods.ToArray(typeof(string));
		}
		//Get the descriptions of all the test methods
		private MethodInfo[] getTestMethods() {
			ArrayList testMethods = new ArrayList();
			MethodInfo[] methods = testClass.GetMethods();
			foreach(MethodInfo method in methods) {
				if(method.Name.StartsWith("test")) {
					if(method.GetParameters().Length == 0) {
						testMethods.Add(method);
					}
				}
			}
			return (MethodInfo[])testMethods.ToArray(typeof(MethodInfo));
		}

		public delegate void TestCompleteCallback(bool passed);
		//Run all the test methods of the current test type
		public TestResult[] runAllTestMethods(TestCompleteCallback callback) {
			ArrayList results = new ArrayList();
			object instance = createInstanceOfTestType();
			foreach(MethodInfo method in getTestMethods()) {
				Exception current = null;
				bool result = true;
				try {
					method.Invoke(instance,null);
				} catch(TargetInvocationException ex) {
					current = ex.InnerException;
					result = false;
				} finally {
					results.Add(new TestResult(method,result,current));
					callback(result);
				}
			}
			return (TestResult[])results.ToArray(typeof(TestResult));
		}
		public bool methodExists(string methodName) {
			MethodInfo method = testClass.GetMethod(methodName, new Type[0]);
			return (method != null);
		}
		//Run a single test method
		public TestResult runSingleTestMethod(string methodName) {
			object instance = createInstanceOfTestType();
			MethodInfo method = testClass.GetMethod(methodName, new Type[0]);
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
			ConstructorInfo defaultConstructor = testClass.GetConstructor(new Type[]{});
			return defaultConstructor.Invoke(null);
		}
		private Type testClass;
	}
}
