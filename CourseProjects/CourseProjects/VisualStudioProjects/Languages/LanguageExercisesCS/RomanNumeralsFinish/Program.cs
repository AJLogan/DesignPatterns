using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RomanNumeralsFinish {
    internal class Program {
        private static RomanNumeral[] numerals;

        private static void Main(string[] args) {
            numerals = new RomanNumeral[9];
            numerals[0] = new RomanNumeral(100, "C");
            numerals[1] = new RomanNumeral(90, "XC");
            numerals[2] = new RomanNumeral(50, "L");
            numerals[3] = new RomanNumeral(40, "XL");
            numerals[4] = new RomanNumeral(10, "X");
            numerals[5] = new RomanNumeral(9, "IX");
            numerals[6] = new RomanNumeral(5, "V");
            numerals[7] = new RomanNumeral(4, "IV");
            numerals[8] = new RomanNumeral(1, "I");

            Console.WriteLine("Enter a number...");
            int number = Convert.ToInt32(Console.ReadLine());

            Console.Write("{0} as a roman numeral is ", number);
            foreach (RomanNumeral numeral in numerals) {
                int times = number / numeral.DecimalValue;

                if(times > 0) {
                    for (int x = 0; x < times; x++) {
                        Console.Write(numeral.StringValue);
                    }
                    number = number % numeral.DecimalValue;
                }
            }
            Console.WriteLine();
        }
    }
}