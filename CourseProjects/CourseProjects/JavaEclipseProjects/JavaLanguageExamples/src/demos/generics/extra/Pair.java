package demos.generics.extra;

public class Pair<T,U> {
	public Pair(T first, U second) {
		super();
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public U getSecond() {
		return second;
	}
	private T first;
	private U second;
}
