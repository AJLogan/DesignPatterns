using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace ParallelLinqQueries {
    class Program {
        static void Main(string[] args) {
            ParallelQuery<Result> results = null;
            results = from e in BuildData().AsParallel().WithDegreeOfParallelism(4)
                      where Func(e.Dept)
                      select new Result {
                          Name = e.Name,
                          ThreadID = Thread.CurrentThread.ManagedThreadId
                      };

            Console.WriteLine("----- PLINQ Results -----");
            results.ForAll((r) => Console.WriteLine("{0} found by thread {1}", r.Name, r.ThreadID));

        }
        private static bool Func(string dept) {
            Random r = new Random();
            Thread.Sleep(r.Next(100));
            return dept == "IT";
        }
        private static List<Employee> BuildData() {
            var data = new List<Employee>();
            for (int x = 0, y = 1; x < 500; x++) {
                switch (y) {
                    case 1:
                        data.Add(new Employee() { Name = "Peter " + x, Dept = "IT" });
                        y++;
                        break;
                    case 2:
                        data.Add(new Employee() { Name = "Lucy " + x, Dept = "HR" });
                        y++;
                        break;
                    case 3:
                        data.Add(new Employee() { Name = "Simon " + x, Dept = "IT" });
                        y++;
                        break;
                    case 4:
                        data.Add(new Employee() { Name = "Hazel " + x, Dept = "HR" });
                        y = 1;
                        break;
                }
            }
            return data;
        }
    }
    public class Result {
        public string Name { get; set; }
        public int ThreadID { get; set; }
    }
    public class Employee {
        public Employee() {
        }
        public Employee(string name, string dept) {
            Name = name;
            Dept = dept;
        }
        public override string ToString() {
            return String.Format("{0} working in {1} of age {2} earning {3}", Name, Dept);
        }
        public string Name { get; set; }
        public string Dept { get; set; }
    }
}

