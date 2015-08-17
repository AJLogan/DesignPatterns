using System;
namespace CSharpStructs {
    struct Person {
        public String surname;
        public String forename;
        public override string ToString() {
            return "Person called " + forename + " " + surname;
        }
        //must assign to both fields in constructor
        public Person(string forename, string surname) {
            this.surname = surname;
            this.forename = forename;
        }
    }
    class Tester {
        static void Main(string[] args) {
            Person p1;
            p1.forename = "Joe";
            p1.surname = "Bloggs";
            //Cant use p1 till all the fields are initialised
            Console.WriteLine("Struct represents: {0}\n", p1);

            Person p2 = new Person();
            //Fields initialised to null
            Console.WriteLine("Struct represents: {0}\n", p2);

            Person p3 = new Person("Dave", "Smith");
            //Fields initialised by constructor
            Console.WriteLine("Struct represents: {0}\n", p3);
        }
    }
}