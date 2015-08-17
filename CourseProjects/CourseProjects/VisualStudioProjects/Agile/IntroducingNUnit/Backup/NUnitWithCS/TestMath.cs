using System;
using NUnit.Framework;

namespace TestBasicMath {
	[TestFixture]
	public class TestMath {
		[SetUp]
		public void Begin() {
			System.Console.WriteLine("SetUp OK");
			mathObj = new BasicMath(30, 20);
		}
		[TearDown]
		public void End() {
			System.Console.WriteLine("TearDown OK");
		}
        [Test]
        [Ignore]
		public void testAddition() {
			Assert.AreEqual(50, mathObj.add(), "addition failed!");
		}
		[Test]
		public void testSubtraction() {
			Assert.AreEqual(10, mathObj.subtract(), "subtraction failed!");
		}
		[Test]
		public void testMultiplication() {
			Assert.AreEqual(600, mathObj.multiply(), "multiplication failed!");
		}
		private BasicMath mathObj;
	}
}