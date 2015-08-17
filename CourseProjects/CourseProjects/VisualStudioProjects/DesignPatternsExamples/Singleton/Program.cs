using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Singleton
{
    class Program
    {
        static void Main(string[] args) {
            var logger1a = DebugLoggerA.GetInstance();
            var logger1b = DebugLoggerA.GetInstance();
            var logger1c = DebugLoggerA.GetInstance();

            logger1a.Log("Bart");
            logger1b.Log("Liza");
            logger1c.Log("Homer");

            Console.WriteLine("Output from logger A:");
            logger1a.WriteMessages(Console.Out);

            var logger2a = DebugLoggerB.GetInstance();
            var logger2b = DebugLoggerB.GetInstance();
            var logger2c = DebugLoggerB.GetInstance();

            logger2a.Log("Fred");
            logger2b.Log("Wilma");
            logger2c.Log("Barney");

            Console.WriteLine("Output from logger B:");
            logger2a.WriteMessages(Console.Out);

            var logger3a = DebugLoggerC.GetInstance();
            var logger3b = DebugLoggerC.GetInstance();
            var logger3c = DebugLoggerC.GetInstance();

            logger3a.Log("Peter");
            logger3b.Log("Lois");
            logger3c.Log("Stewie");

            Console.WriteLine("Output from logger C:");
            logger3a.WriteMessages(Console.Out);

            var logger4a = DebugLoggerD.GetInstance();
            var logger4b = DebugLoggerD.GetInstance();
            var logger4c = DebugLoggerD.GetInstance();

            logger4a.Log("Stan");
            logger4b.Log("Francene");
            logger4c.Log("Klaus");

            Console.WriteLine("Output from logger D:");
            logger4a.WriteMessages(Console.Out);

            var logger5a = DebugLoggerE.GetInstance();
            var logger5b = DebugLoggerE.GetInstance();
            var logger5c = DebugLoggerE.GetInstance();

            logger5a.Log("Stan");
            logger5b.Log("Kyle");
            logger5c.Log("Eric");

            Console.WriteLine("Output from logger E:");
            logger5a.WriteMessages(Console.Out);
        }
    }
}
