using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    class OracleTransaction : ITransaction {
        public void Start() {
            Console.WriteLine("\tOracleTransaction - Start");
        }
        public void Add(Resource r) {
            Console.WriteLine("\tOracleTransaction - Add");
        }
        public void Commit() {
            Console.WriteLine("\tOracleTransaction - Commit");
        }
        public void Rollback() {
            Console.WriteLine("\tOracleTransaction - Rollback");
        }
    }
}