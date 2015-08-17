using System;

namespace CSharpProperties {
	class Person {
        public string Name {
            get { return name; }
            set { name = value; }
        }
		public int Age {
			get { return age; }
			set { age = value; }
		}
        public double Salary {
            get { return salary; }
            //changing access only available in C# 2.0
            internal set { salary = value; }
        }
		private double salary;
		private int age;
		private string name;
	}
}