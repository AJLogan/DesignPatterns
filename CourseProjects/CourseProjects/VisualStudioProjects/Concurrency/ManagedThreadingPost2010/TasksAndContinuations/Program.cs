using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Diagnostics;

namespace TasksAndContinuations {
    class Program {
        static void Main(string[] args) {
            AutoResetEvent resetEvent = new AutoResetEvent(false);

            Task<long> task = new Task<long>(() => PrintMsgs("MyTask"));
            task.ContinueWith((t) => {
                Console.WriteLine("Callback triggered");
                resetEvent.Set();
            });
            task.Start();

            Console.WriteLine("Main thread waiting for task to complete");
            resetEvent.WaitOne();
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

