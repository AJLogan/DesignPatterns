using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton {
    internal class DebugLoggerD {
        private DebugLoggerD() {
            messages = new List<string>();
        }

        static DebugLoggerD() {
            //not used but required for delayed initialization
        }

        public static DebugLoggerD GetInstance() {
            return instance;
        }

        public void Log(string msg) {
            messages.Add(msg);
        }

        public void WriteMessages(TextWriter output) {
            messages.ForEach(output.WriteLine);
        }

        private readonly List<string> messages;
        private static readonly DebugLoggerD instance = new DebugLoggerD();
    }
}