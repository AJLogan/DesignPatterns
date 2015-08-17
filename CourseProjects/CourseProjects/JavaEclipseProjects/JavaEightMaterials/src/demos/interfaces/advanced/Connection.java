package demos.interfaces.advanced;

public interface Connection {
	default void close() {
		System.out.println("Closing the connection...");
	}
}
