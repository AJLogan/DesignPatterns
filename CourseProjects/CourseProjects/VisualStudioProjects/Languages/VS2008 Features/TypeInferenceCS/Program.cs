using System;
using System.Collections.Generic;
using System.Text;

namespace TypeInferenceCS {
    class Program {
        static void Main(string[] args) {
            var obj1 = DateTime.Now;
            var obj2 = "abcdef";
            var obj3 = new MyClass(123.45);

            Console.WriteLine("The date is: {0}",obj1.ToShortDateString());
            Console.WriteLine("The time is: {0}", obj1.ToShortTimeString());
            Console.WriteLine("The length of the string is: {0}", obj2.Length);
            Console.WriteLine("Value returned from MyClass.Func is: {0}", obj3.Func());

        }
    }
}
