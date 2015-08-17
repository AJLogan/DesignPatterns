using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace IntroToMSTest {
    [TestClass]
    public class SkeletonTest {       
        [AssemblyInitialize]
        public static void AssemblyStart(TestContext context) {
            PrintToOut("Assembly level initalize method called");
        }
        [ClassInitialize]
        public static void ClassStart(TestContext context) {
            PrintToOut("Class level initalize method called");
        }
        [TestInitialize]
        public void Start() {
            PrintToOut("Test level initalize method called");
        }
        [AssemblyCleanup]
        public static void AssemblyEnd() {
            PrintToOut("Assembly level cleanup method called");
        }
        [ClassCleanup]
        public static void ClassEnd() {
            PrintToOut("Class level cleanup method called");
        }
        [TestCleanup]
        public void End() {
            PrintToOut("Test level cleanup method called");
        }
        [TestMethod]
        public void T1() {
            PrintToOut("Test One Called");
        }
        [TestMethod]
        public void T2() {
            PrintToOut("Test Two Called");
        }
        [TestMethod]
        public void T3() {
            PrintToOut("Test Three Called");
        }
        private static void PrintToOut(string msg) {
            System.Diagnostics.Debug.WriteLine(msg);
        }
    }
}
