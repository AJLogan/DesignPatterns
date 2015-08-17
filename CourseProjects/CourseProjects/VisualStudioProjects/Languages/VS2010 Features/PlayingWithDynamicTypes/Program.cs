using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PlayingWithDynamicTypes {
    internal class Program {
        private static void Main(string[] args) {
            DemoExpandoObjects();
            DemoDynamicTypes();
        }

        private static void DemoExpandoObjects() {
            dynamic myObj = new ExpandoObject();
            myObj.Name = "Dave Jones";
            myObj.Age = 27;
            myObj.Salary = 32000.00;
            myObj.AwardBonus = new Action<double>((double bonus) => myObj.Salary += bonus);

            UseExpandoObject(myObj);
        }

        private static void UseExpandoObject(dynamic p) {
            Console.WriteLine("Using the ExpandoObject type:");

            string msg = "\tThis is {0} of age {1} earning {2}";
            Console.WriteLine(msg, p.Name, p.Age, p.Salary);
            p.AwardBonus(125.0);
            Console.WriteLine(msg, p.Name, p.Age, p.Salary);
        }

        private static void DemoDynamicTypes() {
            Console.WriteLine("Using the DynamicObject type:");

            dynamic person = new Person();
            person.Salary = 50000.0;
            Console.WriteLine("\tPersons salary starts at {0}", person.Salary);
            person.AwardBonus(1234.5);
            Console.WriteLine("\tPersons salary finishes at {0}", person.Salary);
        }
    }
}