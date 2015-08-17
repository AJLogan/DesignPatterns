using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BasicAspMvcDemos.Models {
    public class Person {
        public string Forename { get; set; }
        public string Surname { get; set; }
        public int Age { get; set; }

        public override string ToString() {
            return String.Format("{0} {1} aged {2}", Forename, Surname, Age);
        }
    }
}