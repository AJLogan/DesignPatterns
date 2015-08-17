package demos.foreach;

import java.util.Iterator;

public class CustomList implements Iterable<Integer> {
	public CustomList() {
		values = new int[] {101,202,303,404,505,606,707,808,909};
	}
	public Iterator<Integer> iterator() {
		return new CustomIterator();
	}
	private class CustomIterator implements Iterator<Integer> {
		public boolean hasNext() {
			return position < values.length;
		}
		public Integer next() {
			return values[position++];
		}
		public void remove() {
			//DO NOTHING...
		}
		private int position;
	}
	private int [] values;
}
