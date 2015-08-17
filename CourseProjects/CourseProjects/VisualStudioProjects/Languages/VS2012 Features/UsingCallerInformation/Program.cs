using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace UsingCallerInformation {
    internal class Program {
        private static void Main(string[] args) {
            Foobar(5, "the cat sat on the mat");
        }

        private static void Foobar(int p1, string p2) {
            LogInfo("Invoked");
            for (int i = 0; i < p1; i++) {
                Console.WriteLine(p2);
            }
            LogInfo("All done");
        }

        private static void LogInfo(string message,
                                    [CallerMemberName] string methodName = "",
                                    [CallerFilePath] string filePath = "",
                                    [CallerLineNumber] int lineInFile = 0)
        {
            var fileName = filePath.Split('\\').Last();
            Console.WriteLine("\"{0}\" from {1} at line {2} in {3}", message, methodName, lineInFile, fileName);
        }
    }
}