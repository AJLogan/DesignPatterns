using System;
using System.Reflection;

namespace CSUnitV2
{
	public class TestResult {
		public TestResult(MethodInfo methodTested, bool result, Exception exception) {
			this.methodTested = methodTested;
			this.result = result;
			this.exception = exception;
		}
		public bool passed {
			get {
				return result;
			}
		}
		public string methodName {
			get {
				return methodTested.Name;
			}
		}
		public Exception error {
			get {
				return exception;
			}
		}
		private bool result;
		private MethodInfo methodTested;
		private Exception exception;
	}
}
