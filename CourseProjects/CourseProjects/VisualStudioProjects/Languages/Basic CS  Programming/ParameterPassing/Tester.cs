using System;
namespace CSharpParameters {
    class Tester {
        static void Main(string[] args) {
            //manipulate type by reference
            int i = 11;
            incrementInt(ref i);
            Console.WriteLine("Integer has been incremented to {0}\n", i);

            //use output parameters
            string str1, str2;
            setStrings(out str1, out str2);
            Console.WriteLine("Strings have been set to {0} and {1}\n", str1, str2);

            //show parameter lists
            int result = addIntegers(20, 30, 40, 50, 60, 70);
            Console.WriteLine("Total of integers is: {0}", result);
        }
        private static void incrementInt(ref int i) {
            i++;
        }
        private static void setStrings(out string s1, out string s2) {
            s1 = "XXXX";
            s2 = "YYYY";
        }
        private static int addIntegers(params int[] args) {
            int total = 0;
            foreach (int i in args) {
                total += i;
            }
            return total;
        }
    }
}