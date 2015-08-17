using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UsingNamedAndOptionalParameters {
    internal class Program {
        private static void Main(string[] args) {
            Console.WriteLine("Showing optional parameters:");
            Log("To be or not to be");
            Log("To thine own self be true", 2);
            Log("Let slip the dogs or war", 3, "Customer.cs");
            Log("To thine own self be true", 4, "Order.cs", "Henry");

            Console.WriteLine("Showing named parameters:");
            Log("The empty vessel makes the loudest sound", where: "Invoice.cs");
            Log("Now is the winter of our discontent", 6, owner: "Jane");
        }

        private static void Log(string message,
                                int? severity = 1,
                                string where = "My Code",
                                string owner = "Dave") {
            const string msg = "\t{0} logged from {1} with severity {2}: {3}";
            Console.WriteLine(msg, owner, where, severity, message);
        }
    }
}