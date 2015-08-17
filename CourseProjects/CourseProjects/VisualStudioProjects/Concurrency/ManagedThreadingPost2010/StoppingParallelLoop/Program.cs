using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace StoppingParallelLoop {
    class Program {
        static void Main(string[] args) {
            ParallelLoopResult result = Parallel.For(10, 50, (int i, ParallelLoopState state) => MyFunc(i, state));
            if (!result.IsCompleted) {
                Console.WriteLine("Loop did not complete fully");
            }
        }
        static void MyFunc(int val, ParallelLoopState state) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            if (val == 30) {
                state.Stop();
            }
            Console.WriteLine("End of iteration {0}", val);
        }
    }
}
