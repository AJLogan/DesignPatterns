using System;
using System.Collections.Generic;
using System.Text;

namespace MultiDimensionalArrays {
    class Program {
        static void Main(string[] args) {
            string[,] array1 = new string[2,3];
            array1[0, 0] = "abc";
            array1[0, 1] = "def";
            array1[0, 2] = "ghi";
            array1[1, 0] = "jkl";
            array1[1, 1] = "mno";
            array1[1, 2] = "pqr";

            string[,] array2 = new string[,] {
                                                 {"abc", "def", "ghi"},
                                                 {"jkl", "mno", "pqr"}
                                             };


            PrintArray(array1);
            PrintArray(array2);
        }
        private static void PrintArray(string[,] array) {
            Console.WriteLine("----- 2d array contents -----");
            for (int x = 0; x < array.GetLength(0); x++) {
                Console.Write("\t");
                for (int y = 0; y < array.GetLength(1); y++) {
                    Console.Write("{0} ", array[x, y]);
                }
                Console.WriteLine();
            }
        }
    }
}