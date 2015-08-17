using System;
using System.Text;
using System.Collections;

namespace LinkedList
{
	public delegate void AddNotification(string item);

	public class LinkedList : IEnumerable {
		public IEnumerator GetEnumerator() {
			return new ListEnumerator(this);
		}
		public bool IsEmpty() {
			return currentSize == 0;
		}
		public void Add(string item) {
			currentSize++;
			if(null == first) {
				first = new Node(item,null);
			} else {
				Node last = MoveToLastNode(first);
				last.After = new Node(item,last);
			}
			if(AddEvent != null) {
				AddEvent(item);
			}
		}
		public int Size {
			get {
				return currentSize;
			}
		}
		public string this[int index] {
			get {
				return GetItem(index);
			}
		}
		private string GetItem(int index) {
			if(IsEmpty()) {
				throw new ListEmptyException("No Items");
			} else if(IndexIsInvalid(index)) {
				throw new ArgumentOutOfRangeException();
			} else {
				return RetrieveItem(index);
			}
		}
		public void Remove(string item) {
			Node toDie;
			if(IsEmpty()) {
				throw new ListEmptyException("Cant remove");
			} else if(null == item || !Exists(item, out toDie)) {
				throw new ArgumentOutOfRangeException();
			} else {
				currentSize--;
				if(first.Item.Equals(item)) {
					RemoveFirstNode();
				} else {
					if(toDie.After == null) {
						RemoveLastNode(toDie);
					} else {
						RemoveNodeFromMiddle(toDie);
					}
				}
			}
		}
		private Node FindNode(string item) {
			Node current = first;
			while(current != null) {
				if(current.Item.Equals(item)) {
					break;
				} else {
					current = current.After;
				}
			}
			return current;
		}
		private void RemoveNodeFromMiddle(Node current) {
			Node beforeCurrent = current.Before;
			Node afterCurrent = current.After;
			beforeCurrent.After = afterCurrent;
			afterCurrent.Before = beforeCurrent;
		}
		private void RemoveLastNode(Node current) {
			Node beforeCurrent = current.Before;
			beforeCurrent.After = null;
		}
		private void RemoveFirstNode() {
			first = first.After;
			if(first != null) {
				first.Before = null;
			}
		}
		private bool Exists(string item, out Node found) {
			Node current = first;
			while(current != null) {
				if(current.Item.Equals(item)) {
					found = current;
					return true;
				} else {
					current = current.After;
				}
			}
			found = null;
			return false;
		}
		public override string ToString() {
			if(IsEmpty()) {
				return "List Is Empty";
			} else {
				StringBuilder sb = new StringBuilder("List Contents:");
				Node current = first;
				while(current != null) {
					sb.Append(" ");
					sb.Append(current.Item);
					current = current.After;
				}
				return sb.ToString();
			}
		}

		private Node MoveToLastNode(Node n) {
			Node current = n;
			while(current.After != null) {
				current = current.After;
			}
			return current;
		}
		private string RetrieveItem(int index) {
			if(index == 0) {
				return first.Item;
			} else {
				Node current = first;
				for(int i=0;i<index;i++) {
					current = current.After;
				}
				return current.Item;
			}
		}
		private bool IndexIsInvalid(int index) {
			return (index < 0 || index > (Size - 1));
		}
		public event AddNotification AddEvent;
		private int currentSize;
		private Node first;
	}
}
