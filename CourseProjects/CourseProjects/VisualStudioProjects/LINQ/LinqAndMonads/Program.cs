using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqAndMonads {
    class Program {
        static void Main(string[] args) {
            var testPerson1 = new Person("Dave", new Address(new Postcode("ABC 123")));
            var testPerson2 = new Person("Pete", new Address(new Postcode(null)));
            var testPerson3 = new Person("Fred", new Address(null));
            var testPerson4 = new Person("Lucy", null);

            PrintPostcode(testPerson1);
            PrintPostcode(testPerson2);
            PrintPostcode(testPerson3);
            PrintPostcode(testPerson4);
        }
        private static void PrintPostcode(Person person) {
            var result = from r in person.Residence
                         from p in r.Location
                         from t in p.Text
                         select t;
            if (result.Worked) {
                Console.WriteLine("Postcode for {0} is \"{1}\"", person.Name, result.Value);
            } else {
                Console.WriteLine("Could not retrieve postcode for {0}", person.Name);
            }
        }
    }
}
