using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqSyntaxCS {
    class Program {
        static void Main(string[] args) {
            var testData = BuildData();
            Query1(testData);
            Query2(testData);
            Query3(testData);
            Query3a(testData);
            Query4(testData);
            Query5(testData);
            Query6(testData);
            Query7(testData);
            Query8(testData);
            Query9(testData);
            Query10(testData);
        }
        private static void Query1(IEnumerable<Employee> testData) {
            var results = from e in testData
                          select e;

            Console.WriteLine("----- Query 1 -----");
            foreach (Employee emp in results) {
                Console.WriteLine(emp);
            }
        }
        private static void Query2(IEnumerable<Employee> testData) {
            var results = from e in testData
                          where e.Dept == "IT"
                          select e;

            Console.WriteLine("----- Query 2 -----");
            foreach (Employee emp in results) {
                Console.WriteLine(emp);
            }
        }
        private static void Query3(IEnumerable<Employee> testData) {
            var results = from e in testData
                          where e.Dept == "IT"
                          select e.Name;

            Console.WriteLine("----- Query 3 -----");
            foreach (String empName in results) {
                Console.WriteLine(empName);
            }
        }
        private static void Query3a(IEnumerable<Employee> testData) {
            var results = testData.Where(e => e.Dept == "IT").Select(e => e.Name);

            Console.WriteLine("----- Query 3a -----");
            foreach (String empName in results)
            {
                Console.WriteLine(empName);
            }
        }
        private static void Query4(IEnumerable<Employee> testData) {
            var results = from e in testData
                          where e.Dept == "IT"
                          select new { e.Name, e.Dept };

            Console.WriteLine("----- Query 4 -----");
            foreach (var x in results) {
                Console.WriteLine("{0} working in {1}",x.Name,x.Dept);
            }
        }
        private static void Query5(IEnumerable<Employee> testData) {
            var results = from e in testData
                          where e.Dept == "IT"
                          select new Person() { Name=e.Name, Age=e.Age };

            Console.WriteLine("----- Query 5 -----");
            foreach (Person p in results) {
                Console.WriteLine(p);
            }
        }
        private static void Query6(IEnumerable<Employee> testData) {
            var results = from e in testData
                          orderby e.Age
                          select new { e.Name, e.Age };
                          

            Console.WriteLine("----- Query 6 -----");
            foreach (var x in results) {
                Console.WriteLine("{0} of age {1}", x.Name, x.Age);
            }
        }
        private static void Query7(IEnumerable<Employee> testData) {
            var results = from e in testData
                          orderby e.Age descending
                          select new { e.Name, e.Age };


            Console.WriteLine("----- Query 7 -----");
            foreach (var x in results) {
                Console.WriteLine("{0} of age {1}", x.Name, x.Age);
            }
        }
        private static void Query8(IEnumerable<Employee> testData) {
            Console.WriteLine("----- Query 8 -----");
            if (testData.All((emp) => { return emp.Age >= 16 && emp.Age <= 65; })) {
                Console.WriteLine("All employees in legal age range");
            }
            else {
                Console.WriteLine("One or more employees should not be employed!");
            }
        }
        private static void Query9(IEnumerable<Employee> testData) {
            IDictionary<string, Employee> results = testData.ToDictionary((emp) => { return emp.Name + "_" + emp.Dept; });
            Console.WriteLine("----- Query 9 -----");
            foreach (string key in results.Keys) {
                Console.WriteLine("{0} indexes {1}", key, results[key]);
            }
        }
        private static void Query10(IEnumerable<Employee> testData) {
            var results = testData.ToLookup((emp) => { return emp.Dept; });
            Console.WriteLine("----- Query 10 -----");
            foreach (var group in results) {
                Console.Write("{0} indexes: ", group.Key);
                foreach (Employee e in results[group.Key]) {
                    Console.Write(e.Name);
                    Console.Write(" ");
                }
                Console.WriteLine();
            }
        }
        private static IEnumerable<Employee> BuildData() {
            var data = new List<Employee>();
            //Test data built using constructors
            data.Add(new Employee("Dave", "IT", 21, 30500.0));
            data.Add(new Employee("Jane", "HR", 22, 31000.0));
            data.Add(new Employee("Fred", "IT", 23, 31500.0));
            data.Add(new Employee("Mary", "HR", 24, 32000.0));
            //Test data built using initializer syntax
            data.Add(new Employee() { Name = "Peter", Dept = "IT", Age = 25, Salary = 32500.0 });
            data.Add(new Employee() { Name = "Lucy", Dept = "HR", Age = 26, Salary = 33000.0 });
            data.Add(new Employee() { Name = "Simon", Dept = "IT", Age = 27, Salary = 33500.0 });
            data.Add(new Employee() { Name = "Hazel", Dept = "HR", Age = 28, Salary = 34000.0 });
            return data;
        }
    }
}
