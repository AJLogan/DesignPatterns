using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ExceptionsAndParallalLoops {
    class Program {
        static void Main(string[] args) {
            try {
                Parallel.For(10, 50, (int i, ParallelLoopState state) => MyFunc(i, state));
            } catch (AggregateException aggregate) {
                Console.WriteLine("Just caught an AggregateException holding:");
                foreach (Exception ex in aggregate.InnerExceptions) {
                    Console.WriteLine("\t {0}", ex.Message);
                }
            }
        }
        static void MyFunc(int val, ParallelLoopState state) {
            Random r = new Random();
            if (val > 30 || val % 2 != 0) {
                Thread.Sleep(500);
                throw new Exception("Exception thrown from iteration " + val);
            } else {
                Thread.Sleep(r.Next(250));
            }
            Console.WriteLine("End of iteration {0}", val);
        }
    }
}
