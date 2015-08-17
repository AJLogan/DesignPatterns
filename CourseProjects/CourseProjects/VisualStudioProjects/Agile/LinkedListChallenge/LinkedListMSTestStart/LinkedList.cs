using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace LinkedListMSTestStart {
    public class LinkedList {
        public bool IsEmpty {
            get { return size == 0; }
        }
        public int Size {
            get { return size; }
        }
        public void Add(string item) {
            if (IsEmpty) {
                first = new Node(null, null, item);
            }
            size++;
        }
        public string this[int index] {
            get {
                return Get(index);
            }
        }
        private string Get(int index) {
            if (index == 0) {
                return first.Item;
            }
            return null;
        }
        private int size;
        private Node first;
    }
}
