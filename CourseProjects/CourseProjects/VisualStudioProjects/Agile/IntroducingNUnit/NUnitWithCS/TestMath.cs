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
		public void AdditionWorks() {
			Assert.AreEqual(50, mathObj.Add(), "addition failed!");
		}
		[Test]
		public void SubtractionWorks() {
			Assert.AreEqual(10, mathObj.Subtract(), "subtraction failed!");
		}
		[Test]
		public void MultiplicationWorks() {
			Assert.AreEqual(600, mathObj.Multiply(), "multiplication failed!");
		}
		private BasicMath mathObj;
	}
}