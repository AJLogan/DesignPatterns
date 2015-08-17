package demos.tdd.easymock.advanced;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}
