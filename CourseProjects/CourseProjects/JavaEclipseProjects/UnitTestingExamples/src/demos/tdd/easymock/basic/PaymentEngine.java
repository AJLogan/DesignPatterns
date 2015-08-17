package demos.tdd.easymock.basic;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}
