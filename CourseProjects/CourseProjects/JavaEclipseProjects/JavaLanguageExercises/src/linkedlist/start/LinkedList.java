package linkedlist.start;

public class LinkedList {

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public void add(String s) {
		if(isEmpty()) {
			first = new Node(s,null,null);
		}
		size++;
	}
	public String get(int i) {
		if(i == 0) {
			return first.getItem();
		}
		return null;
	}
	private int size;
	private Node first;
}
