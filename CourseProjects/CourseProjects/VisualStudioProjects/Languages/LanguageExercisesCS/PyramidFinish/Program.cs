using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PyramidFinish {
    internal class Program {
        private static void Main(string[] args) {
            Console.WriteLine("Enter the height of the pyramid...");
            int height = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Here is a pyramid of height {0}", height);

            int numHashes = 1;

            for (int x = 1; x <= height; x++) {
                int numSpaces = height - x;

                for (int y = 0; y < numSpaces; y++) {
                    Console.Write(" ");
                }
                for (int y = 0; y < numHashes; y++) {
                    Console.Write("#");
                }
                Console.WriteLine();
                numHashes += 2;
            }
        }
    }
}