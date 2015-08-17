/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.jee6.di;


@Visa
public class VisaPaymentsEngine implements PaymentsEngine {
    @Override
    public void makePayment(String account, double amount) {
        System.out.printf("Visa payments engine just paid %.2f into %s\n", amount, account);
    }
}

