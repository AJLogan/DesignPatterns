using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Class_Declarations
{
    class Program {
        static void Main(string[] args) {
            Employee e1 = new Employee("AB12","Dave");
            Employee e2 = new Employee("CD34", "Jane",27);
            Employee e3 = new Employee("EF56", "Peter", 28, 30000.0);

            e1.awardBonus(100);
            e2.awardBonus(200);
            e3.awardBonus(300);

            //The 'WriteLine' method will call 'ToString'
            Console.WriteLine(e1);
            Console.WriteLine(e2);
            Console.WriteLine(e3);
        }
    }
}
