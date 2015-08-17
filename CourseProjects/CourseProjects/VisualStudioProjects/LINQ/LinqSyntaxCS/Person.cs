using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqSyntaxCS {
    public class Person {
        public Person() {
        }
        public Person(string name, int age) {
            Name = name;
            Age = age;
        }
        public override string ToString() {
            return String.Format("{0} of age {1}", Name, Age);
        }
        public string Name { get; set; }
        public int Age { get; set; }
    }
}
