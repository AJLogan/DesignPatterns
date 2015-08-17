using System;

namespace LinkedList {
	public class Node {
		public Node(string item, Node n) {
			payload = item;
			prev = n;
		}
		public Node After {
			get {
				return next;
			}
			set {
				next = value;
			}
		}
		public Node Before {
			get {
				return prev;
			}
			set {
				prev = value;
			}
		}
		public string Item {
			get {
				return payload;
			}
		}
		private Node next;
		private Node prev;
		private readonly string payload;
	}
}
