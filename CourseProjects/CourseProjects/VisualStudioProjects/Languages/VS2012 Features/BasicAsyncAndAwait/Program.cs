using System;
using System.Threading.Tasks;
using System.Threading;

namespace BasicAsyncAndAwait {
    internal class Program {
        private static void Main(string[] args) {
            PrintTime("Main Starts");
            Foo();
            PrintTime("Foo Returns");
            SleepFor(10000);
            PrintTime("Main Ends");
        }


        private async static void Foo() {
            PrintTime("Foo Starts");
            var task = Task.Factory.StartNew(() => Bar());
            var retval = await task;
            PrintTime("Foo Ends With " + retval);
        }

        private static string Bar() {
            PrintTime("Bar Starts");
            SleepFor(5000);
            PrintTime("Bar Ends");
            return "zed";
        }

        private static void PrintTime(string msg) {
            string time = DateTime.Now.ToLongTimeString();
            Console.WriteLine("{0} at {1}",msg,time);
        }

        private static void SleepFor(int time) {
            Thread.Sleep(time);
        }
    }
}