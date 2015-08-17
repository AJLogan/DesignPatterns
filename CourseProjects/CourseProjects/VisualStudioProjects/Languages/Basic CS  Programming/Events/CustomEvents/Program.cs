using System;
using System.Collections.Generic;
using System.Text;

namespace CustomEvents {
    //A delegate type to be registered with events
    public delegate void Callback(int i, double d);
    
    class Program {
        static void Main(string[] args) {
            EventHolder eh = new EventHolder();

            Console.WriteLine("\nDEMO OF CUSTOM EVENT");
            eh.CustomEvent += new Callback(myCallbackOne);
            eh.CustomEvent += new Callback(myCallbackTwo);
            eh.CustomEvent += new Callback(myCallbackThree);
            Console.WriteLine("\n\t----- After adding three delegates -----");
            eh.raiseEvent(7, 8.9);

            Console.WriteLine("\n\t----- After removing one delegate -----");
            eh.CustomEvent -= new Callback(myCallbackTwo);
            eh.raiseEvent(7, 8.9);
        }
        static void myCallbackOne(int i, double d) {
            Console.WriteLine("\tmyCallbackOne {0}, {1}", i, d);
        }
        static void myCallbackTwo(int i, double d) {
            Console.WriteLine("\tmyCallbackTwo {0}, {1}", i, d);
        }
        static void myCallbackThree(int i, double d) {
            Console.WriteLine("\tmyCallbackThree {0}, {1}", i, d);
        }
    }
}
