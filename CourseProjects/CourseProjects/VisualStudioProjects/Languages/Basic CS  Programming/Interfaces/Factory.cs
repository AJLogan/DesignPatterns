using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    class Factory {
        public static ITransaction BuildDefaultTransaction() {
            //return new OracleTransaction();
            //return new SqlServerTransaction();
            return new MySqlTransaction();
        }
    }
}