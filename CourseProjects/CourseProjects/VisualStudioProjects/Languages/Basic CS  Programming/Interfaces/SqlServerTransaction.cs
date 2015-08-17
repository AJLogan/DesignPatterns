using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    class SqlServerTransaction : ITransaction {
        public void Start() {
            Console.WriteLine("\tSqlServerTransaction - Start");
        }
        public void Add(Resource r) {
            Console.WriteLine("\tSqlServerTransaction - Add");
        }
        public void Commit() {
            Console.WriteLine("\tSqlServerTransaction - Commit");
        }
        public void Rollback() {
            Console.WriteLine("\tSqlServerTransaction - Rollback");
        }
    }
}