using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    class Program {
        static void Main(string[] args) {
            ITransaction transaction = Factory.BuildDefaultTransaction();
            transaction.Start();
            transaction.Add(new Resource());
            transaction.Add(new Resource());
            transaction.Commit();
        }
    }
}