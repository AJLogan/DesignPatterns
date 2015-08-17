package demos.tdd.mockito.advanced;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}
