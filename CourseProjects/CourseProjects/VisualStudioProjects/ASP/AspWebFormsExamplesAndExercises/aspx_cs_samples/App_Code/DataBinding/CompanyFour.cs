using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DataBinding {
    public class CompanyFour {
        public CompanyFour() {
            staff = new List<Employee>();
            staff.Add(new Employee("AB12", "Joe A Bloggs", "IT", 10000.0));
            staff.Add(new Employee("CD34", "Jane B Smith", "HR", 20000.0));
            staff.Add(new Employee("EF56", "Joe C Bloggs", "IT", 30000.0));
            staff.Add(new Employee("GH78", "Jane D Smith", "HR", 40000.0));
            staff.Add(new Employee("IJ90", "Joe E Bloggs", "IT", 50000.0));
            staff.Add(new Employee("KL12", "Jane F Smith", "HR", 60000.0));
            staff.Add(new Employee("MN34", "Joe G Bloggs", "IT", 70000.0));
            staff.Add(new Employee("OP56", "Jane H Smith", "HR", 80000.0));
            staff.Add(new Employee("QR78", "Joe I Bloggs", "IT", 90000.0));
            staff.Add(new Employee("ST90", "Jane J Smith", "HR", 100000.0));
            departments = new List<string> {"IT", "HR"};
        }
        public IEnumerable<Employee> Staff {
            get { return staff; }
        }
        public IEnumerable<string> Departments {
            get { return departments; }
        }
        private readonly List<Employee> staff;
        private readonly List<string> departments;
    }
}
