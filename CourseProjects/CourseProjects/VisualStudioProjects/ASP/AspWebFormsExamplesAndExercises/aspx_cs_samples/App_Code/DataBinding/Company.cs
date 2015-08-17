using System.Collections.Generic;

namespace DataBinding {
    public class Company {
        static Company() {
            data = new List<Employee>();
            data.Add(new Employee("AB12", "Joe A Bloggs", "IT", 10000.0));
            data.Add(new Employee("CD34", "Jane B Smith", "HR", 20000.0));
            data.Add(new Employee("EF56", "Joe C Bloggs", "IT", 30000.0));
            data.Add(new Employee("GH78", "Jane D Smith", "HR", 40000.0));
            data.Add(new Employee("IJ90", "Joe E Bloggs", "IT", 50000.0));
            data.Add(new Employee("KL12", "Jane F Smith", "HR", 60000.0));
            data.Add(new Employee("MN34", "Joe G Bloggs", "IT", 70000.0));
            data.Add(new Employee("OP56", "Jane H Smith", "HR", 80000.0));
            data.Add(new Employee("QR78", "Joe I Bloggs", "IT", 90000.0));
            data.Add(new Employee("ST90", "Jane J Smith", "HR", 100000.0));
        }
        public List<Employee> GetEmployees() {
            return data;
        }
        private static readonly List<Employee> data;
    }
}