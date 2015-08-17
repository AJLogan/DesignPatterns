using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TemplateMethod {
    class Program {
        private static void Main(string[] args) {
            char[] data = "abcdefgh".ToCharArray();
            Connection c1 = new HttpConnection();
            Connection c2 = new SmtpConnection();
            c1.SendMessage(data);
            Console.WriteLine("----------------");
            c2.SendMessage(data);
        }
    }
}