using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinkedListMSTestStart {
    public class Node {
        public Node(Node before, Node after, string payload) {
            Previous = before;
            Next = after;
            item = payload;
        }
        public Node Next {
            get;
            set;
        }
        public Node Previous {
            get;
            set;
        }
        public string Item {
            get { return item; }
        }
        private readonly string item;
    }
}
