using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqSyntaxCS {
    public class Employee {
        public Employee() {
        }
        public Employee(string name, string dept, int age, double salary) {
            Name = name;
            Dept = dept;
            Age = age;
            Salary = salary;
        }
        public override string ToString() {
            return String.Format("{0} working in {1} of age {2} earning {3}",Name,Dept,Age,Salary);
        }
        public string Name { get; set; }
        public string Dept { get; set; }
        public int Age { get; set; }
        public double Salary { get; set; }
    }
}
