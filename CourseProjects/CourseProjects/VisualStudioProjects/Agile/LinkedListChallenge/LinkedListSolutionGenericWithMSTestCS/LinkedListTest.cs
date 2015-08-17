using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace GenericLinkedListCS
{
    [TestClass]
	public class LinkedListTest {
        [TestInitialize()]
		public void Begin() {
			list = new LinkedList<string>();
		}
        [TestMethod]
		public void NewListIsEmpty() {
			Assert.IsTrue(list.IsEmpty());
		}
        [TestMethod]
		public void ListWithItemsIsNotEmpty() {
			list.Add("abc");
			Assert.IsFalse(list.IsEmpty());
		}
        [TestMethod]
		public void NewListHasZeroSize() {
			Assert.AreEqual(0,list.Size);
		}
        [TestMethod]
        public void ListWithItemsHasCorrectSize() {
			addTestData();
			Assert.AreEqual(3,list.Size);
		}
        [TestMethod]
		public void CanGetSingleItem() {
			list.Add("abc");
			Assert.AreEqual("abc",list[0]);
		}
        [TestMethod]
        public void CanGetMultipleItems() {
			addTestData();
			Assert.AreEqual("abc",list[0]);
			Assert.AreEqual("def",list[1]);
			Assert.AreEqual("ghi",list[2]);
		}
        [TestMethod]
		[ExpectedException(typeof(ListEmptyException))]
		public void AccessingEmptyListFails() {
			string tmp = list[1];
		}
        [TestMethod]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void AccessingWithNegativeIndexFails() {
			list.Add("abc");
			string tmp = list[-1];
		}
        [TestMethod]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void AccessingWithTooLargeAnIndexFails() {
			addTestData();
			string tmp = list[3];
		}
        [TestMethod]
		public void ToStringWorks() {
			Assert.AreEqual("List Is Empty",list.ToString());
			list.Add("ZZZ");
			Assert.AreEqual("List Contents: ZZZ",list.ToString());
			addTestData();
			Assert.AreEqual("List Contents: ZZZ abc def ghi",list.ToString());
		}
        [TestMethod]
		[ExpectedException(typeof(ListEmptyException))]
		public void RemoveFromEmptyListFails() {
			list.Remove("abc");
		}
        [TestMethod]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void NullArgumentForRemoveFails() {
			addTestData();
			list.Remove(null);
		}
        [TestMethod]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void RemoveWhereItemNotFoundFails() {
			addTestData();
			list.Remove("XXX");
		}
        [TestMethod]
		public void RemovingOnlyItemWorks() {
			list.Add("abc");
			list.Remove("abc");
			Assert.IsTrue(list.IsEmpty());
			Assert.AreEqual(0,list.Size);
			Assert.AreEqual("List Is Empty",list.ToString());
		}
        [TestMethod]
		public void RemovingFirstItemWorks() {
			addTestData();
			list.Remove("abc");
			Assert.IsFalse(list.IsEmpty());
			Assert.AreEqual(2,list.Size);
			Assert.AreEqual("List Contents: def ghi",list.ToString());

		}
        [TestMethod]
		public void RemovingLastItemWorks() {
			addTestData();
			list.Remove("ghi");
			Assert.IsFalse(list.IsEmpty());
			Assert.AreEqual(2,list.Size);
			Assert.AreEqual("List Contents: abc def",list.ToString());
		}
        [TestMethod]
		public void RemovingItemFromMiddleWorks() {
			addTestData();
			list.Remove("def");
			Assert.IsFalse(list.IsEmpty());
			Assert.AreEqual(2,list.Size);
			Assert.AreEqual("List Contents: abc ghi",list.ToString());
		}
		private void addTestData() {
			list.Add("abc");
			list.Add("def");
			list.Add("ghi");
		}
		private LinkedList<string> list;
	}
}
