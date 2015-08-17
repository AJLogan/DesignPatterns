using System;
using NUnit.Framework;

namespace LinkedList
{
	[TestFixture]
	public class LinkedListTest {
		[SetUp]
		public void Begin() {
			list = new LinkedList();
			addCallbackOK = false;
		}
		[Test]
		public void NewListIsEmpty() {
			Assert.IsTrue(list.IsEmpty(),"List Should Be Empty");
		}
		[Test]
		public void ItemsListIsNotEmpty() {
			list.Add("abc");
			Assert.IsFalse(list.IsEmpty(),"Should Not Be Empty");
		}
		[Test]
		public void NewListSize() {
			Assert.AreEqual(0,list.Size,"Size Wrong");
		}
		[Test]
		public void ItemsListSize() {
			addTestData();
			Assert.AreEqual(3,list.Size,"Size Wrong");
		} 
		[Test]
		public void SingleItemGet() {
			list.Add("abc");
			Assert.AreEqual("abc",list[0],"Wrong Item");
		}
		[Test]
		public void MultipleItemsAdd() {
			addTestData();
			Assert.AreEqual("abc",list[0],"Wrong Item A");
			Assert.AreEqual("def",list[1],"Wrong Item B");
			Assert.AreEqual("ghi",list[2],"Wrong Item C");
		}
		[Test]
		[ExpectedException(typeof(ListEmptyException))]
		public void GetOnEmptyList() {
			string tmp = list[1];
		}
		[Test]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void NegativeIndexOnGet() {
			list.Add("abc");
			string tmp = list[-1];
		}
		[Test]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void OverflowIndexOnGet() {
			addTestData();
			string tmp = list[3];
		}
		[Test]
		public void ToStringWorks() {
			Assert.AreEqual("List Is Empty",list.ToString(),"ToString Wrong A");
			list.Add("ZZZ");
			Assert.AreEqual("List Contents: ZZZ",list.ToString(),"ToString Wrong B");
			addTestData();
			Assert.AreEqual("List Contents: ZZZ abc def ghi",list.ToString(),"ToString Wrong C");
		}
		[Test]
		[ExpectedException(typeof(ListEmptyException))]
		public void RemoveFromEmptyList() {
			list.Remove("abc");
		}
		[Test]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void NullArgumentForRemove() {
			addTestData();
			list.Remove(null);
		}
		[Test]
		[ExpectedException(typeof(ArgumentOutOfRangeException))]
		public void RemoveWhereItemNotFound() {
			addTestData();
			list.Remove("XXX");
		}
		[Test]
		public void RemoveOnlyItem() {
			list.Add("abc");
			list.Remove("abc");
			Assert.IsTrue(list.IsEmpty(),"Not Empty");
			Assert.AreEqual(0,list.Size,"Size Wrong");
			Assert.AreEqual("List Is Empty",list.ToString(),"ToString Wrong");
		}
		[Test]
		public void RemoveFirstItem() {
			addTestData();
			list.Remove("abc");
			Assert.IsFalse(list.IsEmpty(),"Should Not Be Empty");
			Assert.AreEqual(2,list.Size,"Size Wrong");
			Assert.AreEqual("List Contents: def ghi",list.ToString(),"ToString Wrong");

		}
		[Test]
		public void RemoveLastItem() {
			addTestData();
			list.Remove("ghi");
			Assert.IsFalse(list.IsEmpty(),"Should Not Be Empty");
			Assert.AreEqual(2,list.Size,"Size Wrong");
			Assert.AreEqual("List Contents: abc def",list.ToString(),"ToString Wrong");
		}
		[Test]
		public void RemoveItemFromMiddle() {
			addTestData();
			list.Remove("def");
			Assert.IsFalse(list.IsEmpty(),"Should Not Be Empty");
			Assert.AreEqual(2,list.Size,"Size Wrong");
			Assert.AreEqual("List Contents: abc ghi",list.ToString(),"ToString Wrong");
		}
		[Test]
		public void ForEachLoop() {
			addTestData();
			string [] results = {"abc","def","ghi"};
			int count = 0;
			foreach(string s in list) {
				Assert.AreEqual(results[count],s,"Value {0} Wrong",results[count]);
				count++;
			}
		}
		[Test]
		public void AddItemCallback() {
			list.AddEvent += new AddNotification(this.callback);
			list.Add("abc");
			Assert.IsTrue(addCallbackOK,"Callback Failed");
		}
		public void callback(string item) {
			if(item.Equals("abc")) {
				addCallbackOK = true;
			}
		}
		private bool addCallbackOK;
		private void addTestData() {
			list.Add("abc");
			list.Add("def");
			list.Add("ghi");
		}
		private LinkedList list;
	}
}
