using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BasicAspMvcDemos.Models {
    public class MyData {
        public MyData() {
            TheVehicle = new Vehicle {Owner = new Person()};
            AddressList = new List<string>();
        }

        public Vehicle TheVehicle { get; set; }
        public List<string> AddressList { get; set; }
        public double Repayment { get; set; }
    }
}