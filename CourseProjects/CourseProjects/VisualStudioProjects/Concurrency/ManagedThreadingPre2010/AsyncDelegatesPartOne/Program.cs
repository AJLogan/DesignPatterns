using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace AsyncDelegatesPartOne {
    public delegate string MyDelegate(int max);

    public class Program {
        public static void Main(string[] args) {
            var d = new MyDelegate(Func);
            IAsyncResult result = d.BeginInvoke(10, null, null);
            while (!result.IsCompleted) {
                Console.WriteLine("Main Waiting");
                Thread.Sleep(125);
            }
            string retval = d.EndInvoke(result);
            Console.WriteLine("Delegate call returned: {0}", retval);
        }
        private static string Func(int max) {
            for (int counter = 0; counter < max; counter++) {
                Console.WriteLine("Func message: {0}", counter);
                Thread.Sleep(250);
            }
            return "Finished!";
        }
    }
}
