using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace StartingThreads {
    class Program {
        private static int outerCount = 0;
        private static object myLock = new object();

        //Method to be run in separate thread
        public static void doWork() {
            int innerCount = 0;
            try {
                while (true) {
                    innerCount++;
                    lock (myLock) {
                        outerCount++;
                    }
                    Console.WriteLine("Thread {0}: inner count now {1}", Thread.CurrentThread.Name, innerCount);
                }
            } catch (ThreadAbortException) {
                Console.WriteLine("Thread {0} terminated, inner count is {1}", Thread.CurrentThread.Name, innerCount);
            }
        }
        public static void Main(string[] args) {
            //Create thread objects to run our threading methods
            var thread1 = new Thread(new ThreadStart(doWork));
            thread1.Name = "T1";

            var thread2 = new Thread(new ThreadStart(doWork));
            thread2.Name = "T2";

            //Start the threads
            thread1.Start();
            thread2.Start();

            //Give the threads time to execute
            Thread.Sleep(2000);

            //Stop the threads
            thread1.Abort();
            thread2.Abort();

            //Wait for the threads to complete
            thread1.Join();
            thread2.Join();

            //Value in outerCounter will usually be equal to the total of the innerCounter fields
            Console.WriteLine("End of main thread - value in outerCounter is {0}", outerCount);
        }
    }
}
