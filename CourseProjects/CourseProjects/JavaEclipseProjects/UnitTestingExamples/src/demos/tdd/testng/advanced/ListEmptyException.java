package demos.tdd.testng.advanced;

@SuppressWarnings("serial")
public class ListEmptyException extends Exception {
	public ListEmptyException(String name) {
		super(name);
	}
}
