using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace IntroToMSTest {
    [TestClass]
    public class BasicMathTest {
        [TestInitialize]
        public void Start() {
            math = new BasicMath(30,20);
        }
        [TestMethod]
        public void AdditionWorks() {
            Assert.AreEqual(50,math.Add());
        }
        [TestMethod]
        public void SubtractionWorks() {
            Assert.AreEqual(10, math.Subtract());
        }
        [TestMethod]
        public void MultiplicationWorks() {
            Assert.AreEqual(600, math.Multiply());
        }
        private BasicMath math;
    }
}
