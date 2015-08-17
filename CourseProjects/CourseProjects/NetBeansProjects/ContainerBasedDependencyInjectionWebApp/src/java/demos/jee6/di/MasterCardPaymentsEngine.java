package demos.jee6.di;

@MasterCard
public class MasterCardPaymentsEngine implements PaymentsEngine {
    @Override
    public void makePayment(String account, double amount) {
        System.out.printf("MasterCard payments engine just paid %.2f into %s\n", amount, account);
    }
}
