using System;
using System.Text;
using System.Collections.Generic;
using System.Collections;

namespace GenericLinkedListCS {
    public class LinkedList<T> {
        public bool IsEmpty() {
            return currentSize == 0;
        }
        public void Add(T item) {
            currentSize++;
            if (null == first) {
                first = new Node<T>(item, null);
            }
            else {
                Node<T> last = MoveToLastNode(first);
                last.After = new Node<T>(item, last);
            }
        }
        public int Size {
            get { return currentSize; }
        }
        public T this[int index] {
            get { return GetItem(index); }
        }
        private T GetItem(int index) {
            if (IsEmpty()) {
                throw new ListEmptyException("No Items");
            }
            else if (IndexIsInvalid(index)) {
                throw new ArgumentOutOfRangeException();
            }
            else {
                return RetrieveItem(index);
            }
        }
        public void Remove(T item) {
            Node<T> toDie;
            if (IsEmpty()) {
                throw new ListEmptyException("Cant remove");
            }
            else if (null == item || !Exists(item, out toDie)) {
                throw new ArgumentOutOfRangeException();
            }
            else {
                currentSize--;
                if (first.Item.Equals(item)) {
                    RemoveFirstNode();
                }
                else {
                    if (toDie.After == null) {
                        RemoveLastNode(toDie);
                    }
                    else {
                        RemoveNodeFromMiddle(toDie);
                    }
                }
            }
        }
        private Node<T> FindNode(T item) {
            Node<T> current = first;
            while (current != null) {
                if (current.Item.Equals(item)) {
                    break;
                }
                else {
                    current = current.After;
                }
            }
            return current;
        }
        private void RemoveNodeFromMiddle(Node<T> current) {
            Node<T> beforeCurrent = current.Before;
            Node<T> afterCurrent = current.After;
            beforeCurrent.After = afterCurrent;
            afterCurrent.Before = beforeCurrent;
        }
        private void RemoveLastNode(Node<T> current) {
            Node<T> beforeCurrent = current.Before;
            beforeCurrent.After = null;
        }
        private void RemoveFirstNode() {
            first = first.After;
            if (first != null) {
                first.Before = null;
            }
        }
        private bool Exists(T item, out Node<T> found) {
            Node<T> current = first;
            while (current != null) {
                if (current.Item.Equals(item)) {
                    found = current;
                    return true;
                }
                else {
                    current = current.After;
                }
            }
            found = null;
            return false;
        }
        public override string ToString() {
            if (IsEmpty()) {
                return "List Is Empty";
            }
            else {
                StringBuilder sb = new StringBuilder("List Contents:");
                Node<T> current = first;
                while (current != null) {
                    sb.Append(" ");
                    sb.Append(current.Item);
                    current = current.After;
                }
                return sb.ToString();
            }
        }

        private Node<T> MoveToLastNode(Node<T> n) {
            Node<T> current = n;
            while (current.After != null) {
                current = current.After;
            }
            return current;
        }
        private T RetrieveItem(int index) {
            if (index == 0) {
                return first.Item;
            }
            else {
                Node<T> current = first;
                for (int i = 0; i < index; i++) {
                    current = current.After;
                }
                return current.Item;
            }
        }
        private bool IndexIsInvalid(int index) {
            return (index < 0 || index > (Size - 1));
        }
        private int currentSize;
        private Node<T> first;
    }
}