using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace BasicParallelForEachLoop {
    class Program {
        static void Main(string[] args) {
            string[] data = { "ab","cd","ef","gh","ij","kl","mn",
                              "op","qr","st","uv","wx","yz" };
            Parallel.ForEach(data, (string str) => MyFunc(str));
        }
        static void MyFunc(string item) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            Console.WriteLine("Finished processing \"{0}\"", item);
        }
    }
}
