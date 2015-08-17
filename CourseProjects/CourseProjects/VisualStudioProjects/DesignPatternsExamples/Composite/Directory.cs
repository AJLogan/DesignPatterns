using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite {
    internal class Directory : Node {
        public Directory(String name) : base(name) {
            contents = new List<Node>();
        }

        public void Add(Node n) {
            contents.Add(n);
        }

        public Node[] Contents() {
            return contents.ToArray();
        }

        public override long Length {
            get { return contents.Sum((n) => n.Length); }
        }

        public override void Print(int depth) {
            PrintPrefix(depth);
            depth++;
            Console.WriteLine(ToString() + ":");
            contents.ForEach((n) => n.Print(depth));
        }

        private readonly List<Node> contents;
    }
}