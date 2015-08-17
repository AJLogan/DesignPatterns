using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace IntroToMSTest {
    [TestClass]
    public class ContextDemoTest {
        public TestContext TestContext {
            get { return testContext; }
            set { testContext = value; }
        }
        [TestMethod]
        public void T1() {
            PrintToOut(string.Format("This is the only test method in '{0}'", testContext.TestName));
            PrintToOut(string.Format("\tTest directory is '{0}'", testContext.TestDir));
            PrintToOut(string.Format("\tTest deployment directory is '{0}'", testContext.TestDeploymentDir));
            PrintToOut(string.Format("\tTest log directory is '{0}'", testContext.TestLogsDir));
        }
        private static void PrintToOut(string msg) {
            System.Diagnostics.Debug.WriteLine(msg);
        }
        private TestContext testContext;
    }
}
