package demos.tdd.testng.advanced;

@SuppressWarnings("serial")
public class ItemNotInListException extends Exception {
	public ItemNotInListException(String msg) {
		super(msg);
	}
}
