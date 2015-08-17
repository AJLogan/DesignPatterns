using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TemplateMethod {
    abstract class Connection {
        public void SendMessage(char[] data) {
            OpenConnection();
            SendData(data);
            CloseConnection();
        }

        protected abstract void OpenConnection();
        protected abstract void SendData(char[] data);
        protected abstract void CloseConnection();
    }
}