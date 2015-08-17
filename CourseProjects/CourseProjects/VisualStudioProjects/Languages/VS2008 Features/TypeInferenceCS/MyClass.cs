using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace TypeInferenceCS {
    public class MyClass {
        public MyClass(double val) : base() {
            this.val = val;
        }
        public double Func() {
            return val;
        }
        private double val;
    }
}
