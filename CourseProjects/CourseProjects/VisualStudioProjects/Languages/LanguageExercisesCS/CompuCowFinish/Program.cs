using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CompuCowFinish {
    class Program {
        /**
            * This is the key for rendering the image:
            * 
            *     space = 0
            *     ( = 1
            *     ) = 2
            *     _ = 3
            *     | = 4
            *     * = 5
            *     - = 6
            *     / = 7
            *     \ = 8
            *     @ = 9
            *     o = 10
            */
        private static readonly byte[][] compuCow = {
		    new byte[] { 0,0,0,0,0,0,0,0,0,0,1,3,3,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 },
		    new byte[] { 0,0,0,0,0,0,0,0,0,7,0,0,0,1,0,1,0,0,0,0,0,3,3,3,3,3,3,0,0,0,0 },
		    new byte[] { 0,0,0,0,0,0,0,0,4,0,0,7,8,3,4,0,0,0,0,0,4,0,0,0,0,0,0,8,0,0,0 },
		    new byte[] { 0,0,0,0,0,0,0,0,4,0,0,4,3,3,3,0,0,0,0,0,4,0,0,0,0,0,0,0,4,0,0 },
		    new byte[] { 0,0,0,0,0,0,0,0,4,0,0,0,6,6,6,9,0,0,0,0,4,3,3,3,3,3,3,3,4,0,0 },
		    new byte[] { 0,0,0,0,0,5,0,0,4,0,0,4,0,0,0,6,6,6,6,0,0,0,4,0,0,0,0,4,0,0,0 },
		    new byte[] { 0,0,0,0,0,0,8,0,4,0,0,4,3,3,3,3,3,0,0,0,0,0,4,0,0,0,0,4,0,0,0,0,0 },
		    new byte[] { 0,0,0,0,0,0,0,8,4,3,3,3,3,3,3,3,3,4,0,0,0,0,4,0,0,0,0,4,0,0,0,0,0 }
	    };
        static void Main(string[] args) {
            ShowSolutionOne();
            Console.WriteLine("\n------------------\n");
            ShowSolutionTwo();
        }
        private static void ShowSolutionTwo() {
            foreach (byte[] subArray in compuCow) {
                foreach (byte b in subArray) {
                    switch (b) {
                        case 0:
                            Console.Write(" ");
                            break;
                        case 1:
                            Console.Write("(");
                            break;
                        case 2:
                            Console.Write(")");
                            break;
                        case 3:
                            Console.Write("_");
                            break;
                        case 4:
                            Console.Write("|");
                            break;
                        case 5:
                            Console.Write("*");
                            break;
                        case 6:
                            Console.Write("-");
                            break;
                        case 7:
                            Console.Write("/");
                            break;
                        case 8:
                            Console.Write("\\");
                            break;
                        case 9:
                            Console.Write("@");
                            break;
                        case 10:
                            Console.Write("o");
                            break;
                    }
                }
                Console.WriteLine();
            }
        }
        private static void ShowSolutionOne() {
            for (int x = 0; x < compuCow.Length; x++) {
                byte[] subArray = compuCow[x];

                for (int y = 0; y < subArray.Length; y++) {
                    byte b = subArray[y];

                    switch (b) {
                        case 0:
                            Console.Write(" ");
                            break;
                        case 1:
                            Console.Write("(");
                            break;
                        case 2:
                            Console.Write(")");
                            break;
                        case 3:
                            Console.Write("_");
                            break;
                        case 4:
                            Console.Write("|");
                            break;
                        case 5:
                            Console.Write("*");
                            break;
                        case 6:
                            Console.Write("-");
                            break;
                        case 7:
                            Console.Write("/");
                            break;
                        case 8:
                            Console.Write("\\");
                            break;
                        case 9:
                            Console.Write("@");
                            break;
                        case 10:
                            Console.Write("o");
                            break;
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
