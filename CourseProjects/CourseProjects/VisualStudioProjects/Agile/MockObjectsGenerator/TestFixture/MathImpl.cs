using System;
using System.Collections;

namespace TestFixture {
	public class MathImpl : Math {
		public override int add(int no1, int no2) {
			return no1 + no2;
		}
		public override int multiply(int no1, int no2) {
			return no1 * no2;
		}
		public override double divide(int no1, int no2) {
			return no1 / ((double)no2);
		}
		public override void accumulate(int num) {
			total += num;
		}
		public override int accumulateTotal() {
			return total;
		}
		private int total;
	}
}
