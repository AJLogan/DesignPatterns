using System;

namespace InheritanceDemo
{
	public class Employee {

		public Employee(string id, string name) : base() {
			this.id = id;
			this.name = name;
		}

		public Employee(string id, string name, int age) : this(id,name) {
			this.age = age;
		}


		public Employee(string id, string name, int age, double salary) : this(id,name,age) {
			this.salary = salary;
		}

		public void markOnHoliday(int days) {
			markOnHoliday();
			holidaysTaken += days;
		}

		public void markOnHoliday() {
			onHoliday = true;
		}

		//method must be virtual to switch on polymorphism
		public virtual void awardBonus(double bonus) {
			salary += bonus;
		}

		public override string ToString() {
			return id + " called " + name + " aged " + age + " earning " + salary;
		}

		//fields
		protected string id;
		protected string name;
		protected int age;
		protected double salary;
		protected bool onHoliday;
		protected int holidaysTaken;
	}
}
