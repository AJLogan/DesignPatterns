using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace CancellingParallelLoop {
    class Program {
        static void Main(string[] args) {
            var tokenSource = new CancellationTokenSource();
            var options = new ParallelOptions { CancellationToken = tokenSource.Token };

            var task = Task.Factory.StartNew(() => {
                Thread.Sleep(1500);
                Console.WriteLine("Cancelling Loop");
                tokenSource.Cancel(true);
            });
            try {
                Parallel.For(10, 50, options, (int i) => MyFunc(i));
            } catch (OperationCanceledException) {
                Console.WriteLine("Just caught exception...");
            }
        }
        static void MyFunc(int val) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            Console.WriteLine("End of iteration {0}", val);
        }
    }
}

