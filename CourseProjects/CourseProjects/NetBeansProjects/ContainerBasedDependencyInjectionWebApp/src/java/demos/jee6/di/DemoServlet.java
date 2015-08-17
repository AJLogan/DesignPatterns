package demos.jee6.di;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DemoServlet", urlPatterns = {"/demo"})
public class DemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("accountNumber");
        double amount = Double.parseDouble(request.getParameter("amount").trim()); 
        String provider = request.getParameter("provider");
        
        makePayment(provider, account, amount);
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writeResponse(writer);
    }
    private void writeResponse(PrintWriter writer) {
        String msg1 = "Payment Made!";
        String msg2 = "Check server log to ensure it went to the correct provider...";
        
        writer.write(String.format("<html><body><h1>%s</h1><h2>%s</h2></body></html>",msg1,msg2));
    }
    private void makePayment(String provider, String account, double amount) {
        if(provider.equals("paypal")) {
            paypalPaymentsEngine.makePayment(account, amount);
        } else if(provider.equals("visa")) {
            visaPaymentsEngine.makePayment(account, amount);
        } else if(provider.equals("mastercard")) {
            mastercardPaymentsEngine.makePayment(account, amount);
        }
    }
    @Inject @PayPal
    private PaymentsEngine paypalPaymentsEngine;
    @Inject @Visa
    private PaymentsEngine visaPaymentsEngine;
    @Inject @MasterCard
    private PaymentsEngine mastercardPaymentsEngine;
}
