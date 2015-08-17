using System;

namespace GenericLinkedListCS {
	public class Node<T> {
		public Node(T item, Node<T> n) {
			payload = item;
			prev = n;
		}
		public Node<T> After {
			get {
				return next;
			}
			set {
				next = value;
			}
		}
		public Node<T> Before {
			get {
				return prev;
			}
			set {
				prev = value;
			}
		}
		public T Item {
			get {
				return payload;
			}
		}
		private Node<T> next;
		private Node<T> prev;
		private readonly T payload;
	}
}
