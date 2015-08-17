using System;
using System.Collections;

namespace LinkedList
{
	
	public class ListEnumerator : IEnumerator {
		public ListEnumerator(LinkedList list) {
			this.list = list;
			counter = -1;
		}
		public void Reset() {
			counter = -1;
		}
		public object Current {
			get {
				return list[counter];
			}
		}
		public bool MoveNext() {
			if(counter == (list.Size - 1)) {
				return false;
			} else {
				counter++;
				return true;
			}
		}
		private LinkedList list;
		private int counter;
	}
}
