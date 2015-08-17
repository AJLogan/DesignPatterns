using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace AsyncDelegatesPartTwo {
    public delegate string MyDelegate(int max);
    class DelegatesDemo {

        static void Main(string[] args) {
            var resetEvent = new AutoResetEvent(false);
            var d = new MyDelegate(Func);

            IAsyncResult result = d.BeginInvoke(10, new AsyncCallback(callback), resetEvent);

            Console.WriteLine("Main about to pause");
            resetEvent.WaitOne();
            Console.WriteLine("Main has been woken");

            string retval = d.EndInvoke(result);
            Console.WriteLine("Delegate call returned: {0}", retval);
        }
        static void callback(IAsyncResult data) {
            Console.WriteLine("Callback has been triggered");
            AutoResetEvent resetEvent = (AutoResetEvent)data.AsyncState;
            resetEvent.Set();
        }
        static string Func(int max) {
            for (int counter = 0; counter < max; counter++) {
                Console.WriteLine("Func message: {0}", counter);
                Thread.Sleep(250);
            }
            return "Finished!";
        }
    }
}

