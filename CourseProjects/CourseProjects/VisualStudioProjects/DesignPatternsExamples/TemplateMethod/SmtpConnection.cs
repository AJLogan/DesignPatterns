using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TemplateMethod {
    class SmtpConnection : Connection {
        protected override void OpenConnection() {
            Console.WriteLine("SmtpConnection.Open");
        }

        protected override void SendData(char[] data) {
            Console.WriteLine("SmtpConnection.Send");
        }

        protected override void CloseConnection() {
            Console.WriteLine("SmtpConnection.Close");
        }
    }
}