using System;

namespace Iterator {
    public class Node<T> {
        public Node(T item, Node<T> n) {
            payload = item;
            Before = n;
        }

        public Node<T> After { get; set; }

        public Node<T> Before { get; set; }

        public T Item {
            get { return payload; }
        }

        private readonly T payload;
    }
}