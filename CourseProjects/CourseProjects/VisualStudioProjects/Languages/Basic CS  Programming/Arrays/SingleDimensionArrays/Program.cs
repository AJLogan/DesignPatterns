using System;
using System.Collections.Generic;
using System.Text;

namespace SingleDimensionArrays {
    class Program {
        static void Main(string[] args) {
            string[] myarray1 = new string[5];
            myarray1[0] = "abc";
            myarray1[1] = "def";
            myarray1[2] = "ghi";
            myarray1[3] = "jkl";
            myarray1[4] = "mno";

            string[] myarray2 = new string[] {"abc", "def", "ghi", "jkl", "mno"};
            string[] myarray3 = {"abc", "def", "ghi", "jkl", "mno"};

            PrintArray(myarray1);
            PrintArray(myarray2);
            PrintArray(myarray3);
        }
        private static void PrintArray(string[] array) {
            Console.WriteLine("----- Array Details -----");
            Console.WriteLine("\tFirst item is {0}", array[0]);
            Console.WriteLine("\tLast item is {0}", array[array.Length - 1]);
            Console.WriteLine("\tFull contents are:");
            foreach (string str in array) {
                Console.WriteLine("\t\t{0}", str);
            }
        }
    }
}