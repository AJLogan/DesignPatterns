package demos.tdd.jmock.basic;

public interface PaymentEngine {
	boolean authorize(String cardNo, double amount);
}