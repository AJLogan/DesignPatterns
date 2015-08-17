using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace UsingTaskObjects {
    class Program {
        static void Main(string[] args) {
            Task t1 = new Task(() => FuncOne());
            Task t2 = new Task(() => FuncTwo());
            Task t3 = new Task(() => FuncThree());

            t1.Start();
            t2.Start();
            t3.Start();

            t1.Wait();
            t2.Wait();
            t3.Wait();
        }
        static void FuncOne() {
            PrintMsgs("Task 1");
        }
        static void FuncTwo() {
            PrintMsgs("Task 2");
        }
        static void FuncThree() {
            PrintMsgs("Task 3");
        }
        static void PrintMsgs(string name) {
            Random r = new Random();
            for (int i = 1; i < 100; i++) {
                Thread.Sleep(r.Next(250));
                Console.WriteLine("Message {0} from {1} on thread {2}",
                                  i, name, Thread.CurrentThread.ManagedThreadId);
            }
        }
    }
}
