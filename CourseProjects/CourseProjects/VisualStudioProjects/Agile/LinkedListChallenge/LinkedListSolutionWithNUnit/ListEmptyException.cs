using System;

namespace LinkedList
{
	public class ListEmptyException : Exception {
		public ListEmptyException(string msg) : base(msg) {
		}
	}
}
