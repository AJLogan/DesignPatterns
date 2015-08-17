using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PartialMethodsCS {
    partial class Test {
        partial void Op2();
        public string Op1(){
            Op2();
            return val;
        }
    }
}
