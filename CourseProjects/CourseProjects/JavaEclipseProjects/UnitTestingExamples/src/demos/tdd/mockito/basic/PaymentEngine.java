package demos.tdd.mockito.basic;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}
