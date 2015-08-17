using System;
using System.Collections.Generic;
using System.Text;

namespace AnonymousDelegates {
    delegate double SomeFunc(int i);

    class Program {
        static void Main(string[] args) {
            SomeFunc sf1 = delegate(int i) {
                               return i*i;
                           };
            SomeFunc sf2 = delegate(int i) {
                               return i/2.0;
                           };
            SomeFunc sf3 = delegate {
                               return 1.234;
                           };

            double result1 = sf1(20);
            double result2 = sf2(15);
            double result3 = sf3(2);

            Console.WriteLine("First results are: {0}, {1}, {2}", result1, result2, result3);
            useDelegates(10, sf1, sf2, sf3);
        }
        private static void useDelegates(int parameter, params SomeFunc[] delegates) {
            Console.Write("Second results are: ");
            foreach (SomeFunc tmp in delegates) {
                Console.Write(" {0}", tmp(parameter));
            }
            Console.WriteLine();
        }
    }
}