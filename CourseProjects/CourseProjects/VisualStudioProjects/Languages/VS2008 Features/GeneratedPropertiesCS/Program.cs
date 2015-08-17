using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GeneratedPropertiesCS {
    class Program {
        static void Main(string[] args) {
            Employee emp1 = new Employee() { Name = "Fred", Age = 27, Salary = 30000.0 };
            Employee emp2 = new Employee() { Name = "Jane", Age = 29, Salary = 40000.0 };

            Console.WriteLine(emp1);
            Console.WriteLine(emp2);
        }
    }
}
