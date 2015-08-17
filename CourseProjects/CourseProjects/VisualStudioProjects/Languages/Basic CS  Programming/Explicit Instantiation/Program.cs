using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ExplicitInstantiation {
    interface Connection {
        void Close();
    }
    interface Shop {
        void Close();
    }
    class MyClass : Connection, Shop {
        void Connection.Close() {
            Console.WriteLine("Connection closed!");
        }
        void Shop.Close() {
            Console.WriteLine("Shop closed!");
        }
    }
    class Program {
        static void Main(string[] args) {
            MyClass mc = new MyClass();
            Shop s = mc;
            Connection c = mc;

            s.Close();
            c.Close();

            //Will not compile
            //mc.Close();
        }
    }
}
