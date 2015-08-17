using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace UsingMonitors {
    class Program {
        private static object myLock = new object();

        static void Main(string[] args) {
            //Create an array of test threads all sharing the same object for locking
            Thread[] threads = new Thread[5];
            for (int i = 0; i < threads.Length; i++) {
                threads[i] = new Thread(new ThreadStart(ThreadFunc));
                threads[i].Name = "T" + i;
            }

            //Acquire the monitor
            Monitor.Enter(myLock);

            //Start the threads up
            foreach (Thread t in threads) {
                t.Start();
            }

            //Keep the lock while our threads try and acquire it
            Thread.Sleep(3000);

            //Release the lock
            Console.WriteLine("\n\nMain thread about to release lock\n");
            Monitor.Exit(myLock);

            //Pause until (hopefully) all threads are in the wait state
            Thread.Sleep(2000);

            Console.WriteLine("\n\nHit return to wake up the threads\n");
            Console.ReadLine();

            //While there ae stil threads running: 
            // 1) Acquire the lock
            // 2) Prepare a waiting thread to acquire the lock
            // 3) Release the lock
            while (threadsAreActive(threads)) {
                Monitor.Enter(myLock);
                Monitor.Pulse(myLock);
                Monitor.Exit(myLock);
            }
        }
        //Find out if any of the threads are still alive
        static bool threadsAreActive(Thread[] threads) {
            foreach (Thread t in threads) {
                if (t.ThreadState != ThreadState.Stopped) {
                    return true;
                }
            }
            return false;
        }
        private static void ThreadFunc() {
            while (true) {
                //Block until we have acquired the mutex
                if (Monitor.TryEnter(myLock, 250)) {
                    Console.WriteLine("{0} has acquired lock", Thread.CurrentThread.Name);
                    //Give up the lock and enter the wait state
                    Monitor.Wait(myLock);
                    //We have been woken and reacquired the lock
                    Console.WriteLine("{0} has woken up", Thread.CurrentThread.Name);
                    //Release the lock
                    Monitor.Exit(myLock);
                    //Exit
                    break;
                } else {
                    Console.WriteLine("{0} failed to acquire lock", Thread.CurrentThread.Name);
                }
            }
        }
    }
}
