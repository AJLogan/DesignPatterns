using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    public class Address {
        public Address(Postcode postcode) {
            this.postcode = postcode;
        }
        public Option<Postcode> Location {
            get {
                if (postcode == null) {
                    return new None<Postcode>();
                }
                else {
                    return new Some<Postcode>(postcode);
                }
            }
        }
        private Postcode postcode;
    }
}
