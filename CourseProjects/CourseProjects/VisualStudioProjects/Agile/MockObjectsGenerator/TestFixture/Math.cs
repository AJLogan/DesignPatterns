using System;

namespace TestFixture {
	public abstract class Math {
		public abstract int add(int no1, int no2);
		public abstract int multiply(int no1, int no2);
		public abstract double divide(int no1, int no2);
		public abstract void accumulate(int num);
		public abstract int accumulateTotal();

	}
}