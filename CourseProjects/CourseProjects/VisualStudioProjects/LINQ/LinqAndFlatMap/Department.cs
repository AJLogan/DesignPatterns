using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndFlatMap {
    class Department {
        public Department() {
            staff = new List<string>();
        }
        public Department addStaff(string name) {
            staff.Add(name);
            return this;
        }
        public string Name { get; set; }
        public string[] Staff {
            get { return staff.ToArray(); }
        }
        private List<string> staff;
    }
}
