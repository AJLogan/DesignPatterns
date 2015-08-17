using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;

namespace AnonymousTypesCS {
    class Program {
        static void Main(string[] args) {
            var obj1 = new { Name = "Dave", Department = "IT", Age = 32, Salary = 40000.0 };

            Console.WriteLine("obj1 is of type: {0}", obj1.GetType().Name);

            foreach(PropertyInfo p in obj1.GetType().GetProperties()){
                Console.WriteLine("\t{0} has value {1}", p.Name, p.GetValue(obj1, null));
            }
        }
    }
}
