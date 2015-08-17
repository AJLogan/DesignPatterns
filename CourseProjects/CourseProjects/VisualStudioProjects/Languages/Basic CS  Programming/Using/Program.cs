using System;
using System.Collections.Generic;
using System.Text;

namespace Using {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("----- 1 -----");
            using (Resource r = new Resource("Resource_A")) {
                r.op1();
            }
            Console.WriteLine("----- 2 -----");
            using (Resource r = new Resource("Resource_B")) {
                r.op1();
            }
            Console.WriteLine("----- 3 -----");
        }
    }
}