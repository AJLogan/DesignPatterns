using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DataDrivenTesting {
    [TestClass]
    public class SampleTest {
        public TestContext TestContext {
            get;
            set;
        }
        [TestMethod]
        [DeploymentItem(@"\TestData\Input.xml")]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.XML",
                    @"|DataDirectory|\TestData\Input.xml",
                    "Employee",DataAccessMethod.Sequential)]
        public void DataDrivenTest() {
            string name = TestContext.DataRow["Name"].ToString();
            string dept = TestContext.DataRow["Dept"].ToString();
            double salary = Convert.ToDouble(TestContext.DataRow["Name"]);
        }
    }
}
