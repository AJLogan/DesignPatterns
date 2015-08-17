using System;

namespace InheritanceDemo
{
	/// <summary>
	/// Summary description for Class1.
	/// </summary>
	class InheritanceDemo
	{
		[STAThread]
		static void Main(string[] args)
		{
			Employee e1 = new Employee();
			Employee e2 = new SalesPerson();
		}
	}
	class Employee 
	{
		private string name;
		private int age;
		private double salary;

		public Employee(string name, int age, double salary) : base() 
		{
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public override string ToString() 
		{
			Console.Write("Employee called: " + name + " of age " + age + " earning " + salary);
		}
	}

	class SalesPerson : Employee 
	{	
		private double target;
		private double bonus;
		public SalesPerson(string name, int age, double salary, double target, double bonus) : base(name,age,salary) 
		{	
			this.target = target;
			this.bonus = bonus;
		}
	}
}
