using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace RecursiveDecomposition {
    class Program {
        static void Main(string[] args) {
            string[] data = { "ab","cd","ef","gh","ij","kl","mn",
                              "op","qr","st","uv","wx","yz" };
            Process(0, data, 0, data.Length - 1);
        }
        private static void Process(int recursionNumber, string[] data, int startIndex, int endIndex) {
            int length = endIndex - startIndex;
            if (length > 4) {
                int split = startIndex + length / 2;
                Parallel.Invoke(
                                    () => Process(recursionNumber + 1, data, startIndex, split),
                                    () => Process(recursionNumber + 2, data, split + 1, endIndex)
                                );
            } else {
                for (int i = startIndex; i <= endIndex; i++) {
                    HandleItem(recursionNumber, data[i]);
                }
            }
        }
        private static void HandleItem(int recursionNumber, string item) {
            Random r = new Random();
            Thread.Sleep(r.Next(500));
            Console.WriteLine("Just processsed {0} in recursion {1}", item, recursionNumber);
        }
    }
}
