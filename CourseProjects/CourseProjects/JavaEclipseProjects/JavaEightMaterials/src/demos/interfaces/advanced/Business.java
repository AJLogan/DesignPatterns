package demos.interfaces.advanced;

public interface Business {
	default void close() {
		System.out.println("Closing the business...");
	}
}
