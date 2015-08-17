using System;

namespace GenericLinkedListCS
{
	public class ListEmptyException : Exception {
		public ListEmptyException(string msg) : base(msg) {
		}
	}
}
