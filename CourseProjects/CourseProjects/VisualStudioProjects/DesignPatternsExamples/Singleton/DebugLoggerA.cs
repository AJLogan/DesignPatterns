using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton {
    internal class DebugLoggerA {
        private DebugLoggerA() {
            messages = new List<string>();
        }

        public static DebugLoggerA GetInstance() {
            if (instance == null) {
                instance = new DebugLoggerA();
            }
            return instance;
        }

        public void Log(string msg) {
            messages.Add(msg);
        }

        public void WriteMessages(TextWriter output) {
            messages.ForEach(output.WriteLine);
        }

        private readonly List<string> messages;
        private static DebugLoggerA instance;
    }
}