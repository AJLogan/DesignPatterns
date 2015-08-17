using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite {
    internal class File : Node {
        public File(string name, long size) : base(name) {
            this.size = size;
        }

        public override String ToString() {
            return name + "(" + size + ")";
        }

        public override long Length {
            get { return size;  }
        }

        public override void Print(int depth) {
            PrintPrefix(depth);
            Console.WriteLine(this);
        }

        private readonly long size;
    }
}