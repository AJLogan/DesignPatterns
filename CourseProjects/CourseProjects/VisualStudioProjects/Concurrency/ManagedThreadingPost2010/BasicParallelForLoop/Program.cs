using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace BasicParallelForLoop {
    class Program {
        static void Main(string[] args) {
            Parallel.For(10, 50, (int i) => MyFunc(i));
        }
        static void MyFunc(int val) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            Console.WriteLine("End of iteration {0}", val);
        }
    }
}
