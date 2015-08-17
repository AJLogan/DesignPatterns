using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton {
    internal class DebugLoggerE {
        private DebugLoggerE() {
            messages = new List<string>();
        }

        public static DebugLoggerE GetInstance() {
            return instance.Value;
        }

        public void Log(string msg) {
            messages.Add(msg);
        }

        public void WriteMessages(TextWriter output) {
            messages.ForEach(output.WriteLine);
        }

        private readonly List<string> messages;
        private static readonly Lazy<DebugLoggerE> instance = new Lazy<DebugLoggerE>(() => new DebugLoggerE());
    }
}