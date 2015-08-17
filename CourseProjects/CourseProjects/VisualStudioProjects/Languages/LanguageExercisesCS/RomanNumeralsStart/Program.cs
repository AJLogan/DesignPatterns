using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RomanNumeralsStart {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Enter a number...");
            int number = Convert.ToInt32(Console.ReadLine());
            Console.Write("{0} as a roman numeral is ", number);
            Console.Write("XXVVII");
            Console.WriteLine();
        }
    }
}
