using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton {
    class DebugLoggerC {
        private DebugLoggerC() {
            messages = new List<string>();
        }

        public static DebugLoggerC GetInstance() {
            if (instance == null) {
                lock (mutex) {
                    if (instance == null) {
                        instance = new DebugLoggerC();
                    }
                }
            }
            return instance;
        }

        public void Log(string msg) {
            messages.Add(msg);
        }

        public void WriteMessages(TextWriter output){
            messages.ForEach(output.WriteLine);
        }

        private readonly List<string> messages;
        private static readonly object mutex = new object();
        private static volatile DebugLoggerC instance;
    }
}