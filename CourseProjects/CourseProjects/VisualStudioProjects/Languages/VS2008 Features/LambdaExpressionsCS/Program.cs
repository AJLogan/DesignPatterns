using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LambdaExpressionsCS {
    public delegate double MyDelegate(int no1, int no2);

    class Program {
        static void Main(string[] args) {
            MyDelegate delegate1 = (a, b) => Convert.ToDouble(a) / b;
            Func<int, int, double> lambda1 = (a, b) => (Convert.ToDouble(a) / b) + 1;

            PrintResultV1(delegate1);
            PrintResultV2(lambda1);
            PrintResultV1((a, b) => (Convert.ToDouble(a) / b) + 2);
            PrintResultV2((a, b) => (Convert.ToDouble(a) / b) + 3);
            PrintResultV1((a, b) => (Convert.ToDouble(a) / b) + 4);
            PrintResultV2((a, b) => (Convert.ToDouble(a) / b) + 5);

            Action<int, double> lambda2 = (a,b) => Console.WriteLine("Values are {0} and {1}",a,b);

            DoPrinting(lambda2,12,3.4);
            DoPrinting(lambda2,56,7.8);
        }
        static void PrintResultV1(MyDelegate param) {
            Console.WriteLine("Result is {0}", param(17,4));
        }
        static void PrintResultV2(Func<int, int, double> param) {
            Console.WriteLine("Result is {0}", param(17, 4));
        }
        static void DoPrinting(Action<int, double> param, int v1, double v2) {
            param(v1,v2);
        }
    }
}
