using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PartialMethodsCS {
    partial class Test {
        partial void Op2(){
            val = "ABCDEF";
        }
        private string val;
    }
}
