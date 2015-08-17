using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite {
    internal abstract class Node {
        public Node(string name) {
            this.name = name;
        }

        public override string ToString() {
            return name;
        }

        public void Print() {
            Print(0);
        }

        public abstract long Length { get; }
        public abstract void Print(int depth);

        protected void PrintPrefix(int depth) {
            for (int i = 0; i < depth; i++) {
                Console.Write("----");
            }
            Console.Write("->");
        }

        protected String name;
    }
}