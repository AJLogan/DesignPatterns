using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LinkedListMSTestStart {
    [TestClass]
    public class LinkedListTest {
        [TestInitialize]
        public void Start() {
            theList = new LinkedList();
        }
        [TestMethod]
        public void NewListIsEmpty() {
            Assert.IsTrue(theList.IsEmpty);
            Assert.AreEqual(0, theList.Size);
        }
        [TestMethod]
        public void ListWithItemsIsntEmpty() {
            AddSampleData();
            Assert.IsFalse(theList.IsEmpty);
            Assert.AreEqual(5, theList.Size);
        }
        [TestMethod]
        public void SingleItemCanBeFetched() {
            theList.Add("abc");
            Assert.AreEqual("abc", theList[0]);
        }
        [TestMethod]
        [Ignore]
        public void MultipleItemsCanBeFetched() {
            AddSampleData();
            Assert.AreEqual("abc", theList[0]);
            Assert.AreEqual("def", theList[1]);
            Assert.AreEqual("ghi", theList[2]);
            Assert.AreEqual("jkl", theList[3]);
            Assert.AreEqual("mno", theList[4]);
        }
        private void AddSampleData() {
            theList.Add("abc");
            theList.Add("def");
            theList.Add("ghi");
            theList.Add("jkl");
            theList.Add("mno");
        }
        private LinkedList theList;
    }
}
