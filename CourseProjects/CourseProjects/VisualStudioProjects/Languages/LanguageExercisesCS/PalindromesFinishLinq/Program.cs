using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PalindromesFinishLinq {
    internal class Program {
        private const string data1 = "A man, a plan, a canal, Panama";
        private const string data2 = "Gold is where you find it";
        private const string data3 = "If I had a hi-fi";
        private const string data4 = "Fortune favors the prepared mind";
        private const string data5 = "Rats live on no evil star";
        private const string data6 = "There is no abstract living";
        private const string data7 = "Some men interpret nine memos";

        private static void Main(string[] args) {
            Test(data1);
            Test(data2);
            Test(data3);
            Test(data4);
            Test(data5);
            Test(data6);
            Test(data7);
        }

        private static void Test(string input) {
            if (TestForPalindrome(input)) {
                Console.WriteLine("{0} is a palindrome", input);
            }
            else {
                Console.WriteLine("{0} is NOT a palindrome", input);
            }
        }

        private static bool TestForPalindrome(string input) {
            string converted = RemovePunctuation(input.ToLower());
            return converted == new string(converted.Reverse().ToArray());
        }
        private static string RemovePunctuation(string input) {
            var letters = from c in input
                          where c >= 'a' && c <= 'z'
                          select c;

            return new string(letters.ToArray());
        }
    }
}