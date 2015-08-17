using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    public class Postcode {
        public Postcode(String value) {
            this.value = value;
        }
        public Option<String> Text {
            get {
                if (value == null) {
                    return new None<String>();
                }
                else {
                    return new Some<String>(value);
                }
            }
        }
        private String value;
    }
}
