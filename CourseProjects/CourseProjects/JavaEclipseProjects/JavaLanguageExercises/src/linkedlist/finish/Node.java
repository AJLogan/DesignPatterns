package linkedlist.finish;

class Node {
	public Node(Object value, Node other) {
		this.payload = value;
		previous = other;
		next = null;
	}
	public Node getNext() {
		return next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setNext(Node other) {
		next = other;
		if(other != null) {
			other.previous = this;
		}
	}
	public void setPrevious(Node other) {
		previous = other;
		if(other != null) {
			other.next = this;
		}
	}
	public String toString() {
		return String.valueOf(payload);
	}
	public Object getPayload() {
		return payload;
	}
	private Node next;
	private Node previous;
	private Object payload;
}

