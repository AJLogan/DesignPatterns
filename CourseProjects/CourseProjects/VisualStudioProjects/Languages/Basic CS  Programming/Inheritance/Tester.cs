using System;

namespace InheritanceDemo
{
	class Tester {

		static void Main(string[] args) {
			Employee e1 = new Employee("ABC123","Joe Bloggs",27,20000);
			Employee e2 = new SalesPerson("DEF456","Jane Smith",32,40000,120000);

			Console.WriteLine("\n------Before awarding bonus------");
			Console.WriteLine("e1 is {0}\ne2 is {1}",e1,e2);

			e1.awardBonus(500);
			e2.awardBonus(500);

			Console.WriteLine("\n------After awarding bonus------");
			Console.WriteLine("e1 is {0}\ne2 is {1}",e1,e2);

		}
	}
}
