package demos.jee6.di;

@PayPal
public class PaypalPaymentsEngine implements PaymentsEngine {
    @Override
    public void makePayment(String account, double amount) {
        System.out.printf("Paypal payments engine just paid %.2f into %s\n", amount, account);
    }
}
