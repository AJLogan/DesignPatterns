using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ClassDeclarationsFinishV2 {
    internal class Program {
        private static void Main(string[] args) {
            Student s1 = new Student("Joe Bloggs", "Philosophy", 2, new double[] {68.4, 72.3, 59.8, 62.1});
            Student s2 = new Student("Jane Smith", "Physics", 3, new double[] {84.5, 66.7, 73.2, 60.9});

            Console.WriteLine("--- Objects after creation ---");
            Console.WriteLine(s1);
            Console.WriteLine(s2);

            s1.Year = 3;
            s2.Year = 4;

            Console.WriteLine("\n--- Objects after property change ---");
            Console.WriteLine(s1);
            Console.WriteLine(s2);

            Console.WriteLine("\n--- Average marks are ---");
            Console.WriteLine(s1.Average());
            Console.WriteLine(s2.Average());
        }
    }
}