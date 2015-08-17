using System;

namespace ExtensionObjects {
	class Accumulate {
		public double addValue(double p1) {
			total += p1;
			return total;
		}
		private double total;
	}
}
