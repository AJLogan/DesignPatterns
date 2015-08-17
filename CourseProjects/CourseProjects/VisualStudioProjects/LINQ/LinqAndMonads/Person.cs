using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    public class Person {
        public Person(string name, Address address) {
            this.name = name;
            this.address = address;
        }
        public string Name {
            get { return name; }
        }
        public Option<Address> Residence {
            get {
                if (address == null) {
                    return new None<Address>();
                }
                else {
                    return new Some<Address>(address);
                }
            }
        }
        private string name;
        private Address address;
    }
}
