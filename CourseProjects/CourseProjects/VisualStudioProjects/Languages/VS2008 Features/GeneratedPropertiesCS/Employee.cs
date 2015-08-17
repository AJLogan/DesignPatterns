using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GeneratedPropertiesCS {
    class Employee {
        public override string ToString() {
            return string.Format("{0} of age {1} earning {2}", Name, Age, Salary);
        }
        public string Name { get; set; }
        public int Age { get; set; }
        public double Salary { get; set; }
    }
}
