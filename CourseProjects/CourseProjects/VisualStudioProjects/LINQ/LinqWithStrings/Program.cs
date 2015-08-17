using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinqWithStrings {
    class Program {
        static void Main(string[] args) {
            string input = "  abc-def#ghi+jkl  ";
            string output = RemovePunctuation(input);

            Console.WriteLine(output);
        }
        private static string RemovePunctuation(string input) {
            var letters = from c in input.ToLower()
                          where c >= 'a' && c <= 'z'
                          select c;

            return new string(letters.ToArray());
        }
    }
}
