using System;
using System.Threading;

namespace UnitTestingTest {
	
	//Our tester class
	public class SampleUnitTest {
		public SampleUnitTest() {}
		public void testAdd() {
			simulateDelay();
			if(5 != BasicMath.add(3,2)) {
				throw new MathException("Cant add!");
			}
		}
		public void testSubtract() {
			simulateDelay();
			if(3 != BasicMath.subtract(5,2)) {
				throw new MathException("Cant subtract!");
			}
		}
		public void testMultiply() {
			simulateDelay();
			if(6 != BasicMath.multiply(3,2)) {
				throw new MathException("Cant multiply!");
			}
		}
		public void testDivideWithoutRemainder() {
			simulateDelay();
			if(3 != BasicMath.divide(6,2)) {
				throw new MathException("Cant divide!");
			}
		}
		public void testDivideWithRemainder() {
			simulateDelay();
			if(4.5 != BasicMath.divide(9,2)) {
				throw new MathException("Cant divide!");
			}
		}
		public void testGreater() {
			simulateDelay();
			if(12 != BasicMath.greater(9,12)) {
				throw new MathException("Cant find greater!");
			}
		}
		public void testLesser() {
			simulateDelay();
			if(9 != BasicMath.lesser(9,12)) {
				throw new MathException("Cant find lesser!");
			}
		}
		private void simulateDelay() {
			Thread.Sleep(250);
		}
	}
	//A custom exception to throw
	public class MathException : Exception {
		public MathException(string msg) : base(msg) {}
	}
	//The class to be tested
	public class BasicMath {
		public static int add(int p1, int p2) {
			return p1 + p2;
		}
		public static int subtract(int p1, int p2) {
			return p1 - p2;
		}
		public static int multiply(int p1, int p2) {
			return p1 * p2;
		}
		public static int divide(int p1, int p2) {
			return p1 / p2;
		}
		public static int greater(int p1, int p2) {
			return (p1 > p2) ? p1 : p2;
		}
		public static int lesser(int p1, int p2) {
			return (p1 < p2) ? p1 : p2;
		}

	}
}
