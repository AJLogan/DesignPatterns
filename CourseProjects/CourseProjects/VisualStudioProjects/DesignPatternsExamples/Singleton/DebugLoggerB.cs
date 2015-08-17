using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton {
    class DebugLoggerB {
        private DebugLoggerB() {
            messages = new List<string>();
        }

        public static DebugLoggerB GetInstance() {
            lock (mutex) {
                if (instance == null) {
                    instance = new DebugLoggerB();
                }
                return instance;
            }
        }

        public void Log(string msg) {
            messages.Add(msg);
        }

        public void WriteMessages(TextWriter output) {
            messages.ForEach(output.WriteLine);
        }

        private readonly List<string> messages;
        private readonly static object mutex = new object();
        private static DebugLoggerB instance;
    }
}