using System;
using System.Collections.Generic;
using System.Text;

namespace NormalDelegates {
    delegate double SomeFunc(int i);

    class Program {
        static void Main(string[] args) {
            SomeFunc sf1 = new SomeFunc(TestOne.square);
            SomeFunc sf2 = new SomeFunc(TestOne.half);

            TestTwo t1 = new TestTwo(20);
            TestTwo t2 = new TestTwo(15);
            SomeFunc sf3 = new SomeFunc(t1.multiply);
            SomeFunc sf4 = new SomeFunc(t2.divide);

            double result1 = sf1(20);
            double result2 = sf2(15);
            double result3 = sf3(2);
            double result4 = sf4(10);

            Console.WriteLine("First results are: {0}, {1}, {2}, {3}", result1, result2, result3, result4);

            useDelegates(10, sf1, sf2, sf3, sf4);
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