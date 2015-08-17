package demos.tdd.jmock.advanced;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}