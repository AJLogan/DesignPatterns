using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace BasicParallelInvokeLoop {
    class Program {
        static void Main(string[] args) {
            Parallel.Invoke(
                                () => Func1(),
                                () => Func2(),
                                () => Func3(),
                                () => Func4()
                            );
        }
        static void Func1() {
            DoMessages("Func1");
        }
        static void Func2() {
            DoMessages("Func2");
        }
        static void Func3() {
            DoMessages("Func3");
        }
        static void Func4() {
            DoMessages("Func4");
        }
        static void DoMessages(string name) {
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                Thread.Sleep(r.Next(500));
                Console.WriteLine("Function {0} message {1}", name, i);
            }
        }
    }
}

