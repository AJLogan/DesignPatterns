using System;

namespace InheritanceDemo
{
	public class SalesPerson : Employee {	
		private double target;

		public SalesPerson(string id, string name, int age, double salary, double target) : base(id,name,age,salary) {	
			this.target = target;
		}

		//method must be override to enable polymorphism
		public override void awardBonus(double bonus) {
			salary += (bonus * 2);
		}

		public override string ToString() {
			return base.ToString() + " with target of " + target;
		}
	}
}
