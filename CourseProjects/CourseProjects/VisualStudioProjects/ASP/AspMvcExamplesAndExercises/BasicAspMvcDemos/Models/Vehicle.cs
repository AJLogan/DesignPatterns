using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BasicAspMvcDemos.Models {
    public class Vehicle {
        public string Manufacturer { get; set; }
        public string Model { get; set; }
        public Person Owner { get; set; }

        public override string ToString() {
            string msg = "A {0} {1} driven by {2}";
            return string.Format(msg, Manufacturer, Model, Owner);
        }
    }
}