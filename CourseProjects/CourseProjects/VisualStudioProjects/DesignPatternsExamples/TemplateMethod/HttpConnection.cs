using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TemplateMethod {
    class HttpConnection : Connection {
        protected override void OpenConnection() {
            Console.WriteLine("HttpConnection.Open");
        }

        protected override void SendData(char[] data) {
            Console.WriteLine("HttpConnection.Send");
        }

        protected override void CloseConnection() {
            Console.WriteLine("HttpConnection.Close");
        }
    }
}