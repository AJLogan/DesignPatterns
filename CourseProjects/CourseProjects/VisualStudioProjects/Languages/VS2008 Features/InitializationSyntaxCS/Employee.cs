using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace InitializationSyntaxCS {
    public class Employee {
        public string Name {
            get { return name; }
            set { name = value; }
        }
        public int Age {
            get { return age;  }
            set { age = value; }
        }
        public double Salary {
            get { return salary;  }
            set { salary = value; }
        }
        public override string ToString() {
            return string.Format("{0} of age {1} earning {2}", name, age, salary);
        }
        private string name;
        private int age;
        private double salary;
    }
}
