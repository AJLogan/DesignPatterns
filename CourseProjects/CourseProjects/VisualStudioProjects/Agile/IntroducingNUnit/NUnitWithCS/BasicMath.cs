using System;

namespace TestBasicMath {
	public class BasicMath {
		public BasicMath(int no1, int no2) : base() {
			this.no1 = no1;
			this.no2 = no2;
		}
		public int Add() {
			return no1 + no2;
		}
		public int Subtract() {
			return no1 - no2;
		}
		public int Multiply() {
			return no1*no2;
		}
		private int no1;
		private int no2;
	}
}