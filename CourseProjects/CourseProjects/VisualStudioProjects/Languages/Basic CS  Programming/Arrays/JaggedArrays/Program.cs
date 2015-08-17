using System;
using System.Collections.Generic;
using System.Text;

namespace JaggedArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            string[][] array1 = new string[3][];
            array1[0] = new string[] { "abc", "def", "ghi", "jkl" };
            array1[1] = new string[] { "mno", "pqr", "stu" };
            array1[2] = new string[] { "vwx", "yza" };
            


            string[][] array2 = new string[][] {
                                                 new string[] {"abc", "def", "ghi", "jkl"},
                                                 new string[] { "mno", "pqr", "stu"},
                                                 new string[] { "vwx", "yza"}
                                             };
            PrintArray(array1);
            PrintArray(array2);
        }
        private static void PrintArray(string[][] array)
        {
            Console.WriteLine("----- jagged array contents -----");
            foreach (string [] subArray in array) 
            {
                Console.Write("\t");
                foreach (string str in subArray) 
                {
                    Console.Write("{0} ", str);
                }
                Console.WriteLine();
            }
        }
    }
}
