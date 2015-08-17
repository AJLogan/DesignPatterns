using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndFlatMap {
    class Program {
        static void Main(string[] args) {
            var company = buildListOfDepts();
            var allStaff = company.SelectMany(dept => dept.Staff);

            Console.WriteLine("All members of staff are:");
            foreach(string name in allStaff) {
                Console.WriteLine("\t{0}", name);
            }
        }
        private static List<Department> buildListOfDepts() {
            var it = new Department();
            it.Name = "IT";
            it.addStaff("Dave").addStaff("Pete").addStaff("Susan");

            var hr = new Department();
            hr.Name = "HR";
            hr.addStaff("Jason").addStaff("Mary").addStaff("Simon");

            var sales = new Department();
            sales.Name = "Sales";
            sales.addStaff("Helen").addStaff("Trevor").addStaff("Martin");

            return new List<Department>() { it, hr, sales };
        }
    }
}
