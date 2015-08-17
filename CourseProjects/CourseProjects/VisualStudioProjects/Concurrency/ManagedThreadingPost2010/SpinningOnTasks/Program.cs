using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace SpinningOnTasks {
    class Program {
        static void Main(string[] args) {
            Task<long> task = new Task<long>(() => PrintMsgs("MyTask"));
            task.Start();

            while (!task.IsCompleted) {
                Thread.Sleep(500);
                Console.WriteLine("Main thread waiting for task to complete");
            }
            Console.WriteLine("Task completed in {0} milliseconds", task.Result);
            Console.WriteLine("Main thread exiting");
        }
        static long PrintMsgs(string name) {
            Random r = new Random();
            Stopwatch sw = Stopwatch.StartNew();
            for (int i = 1; i < 50; i++) {
                Thread.Sleep(r.Next(250));
                Console.WriteLine("Message {0} from {1} on thread {2}",
                                  i, name, Thread.CurrentThread.ManagedThreadId);
            }
            sw.Stop();
            return sw.ElapsedMilliseconds;
        }
    }
}

