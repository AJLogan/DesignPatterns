using System;
using System.Collections.Generic;
using System.Text;

namespace Using {
    class Resource : IDisposable {
        public Resource(string name) {
            this.name = name;
        }
        public void op1() {
            Console.WriteLine("\tResource op1 called");
        }
        public void Dispose() {
            Console.WriteLine("\tDispose called on Resource object called {0}", name);
        }
        private string name;
    }
}