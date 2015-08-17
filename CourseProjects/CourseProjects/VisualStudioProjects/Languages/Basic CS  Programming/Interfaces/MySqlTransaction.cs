using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    class MySqlTransaction : ITransaction {
        public void Start() {
            Console.WriteLine("\tMySqlTransaction - Start");
        }
        public void Add(Resource r) {
            Console.WriteLine("\tMySqlTransaction - Add");
        }
        public void Commit() {
            Console.WriteLine("\tMySqlTransaction - Commit");
        }
        public void Rollback() {
            Console.WriteLine("\tMySqlTransaction - Rollback");
        }
    }
}