using System;

namespace CSharpProperties {
	class Tester {
		static void Main(string[] args) {
			Person person = new Person();
			person.Name = "Joe Bloggs";
			person.Age = 27;
			person.Salary = 30000.00;

			Console.WriteLine("Person called {0} of age {1}, earning {2}",person.Name,person.Age, person.Salary);
		}
	}
}