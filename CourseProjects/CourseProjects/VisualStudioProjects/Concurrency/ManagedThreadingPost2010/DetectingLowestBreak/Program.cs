using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DetectingLowestBreak {
    class Program {
        static void Main(string[] args) {
            Parallel.For(10, 50, (int i, ParallelLoopState state) => MyFunc(i, state));
        }
        static void MyFunc(int val, ParallelLoopState state) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            if (val == 30) {
                state.Break();
            } else if (state.LowestBreakIteration != null) {
                Console.WriteLine("Iteration {0} ending because of a break...", val);
                return;
            }
            Console.WriteLine("End of iteration {0}", val);
        }
    }
}
