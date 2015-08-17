package patterns.proxy;

public interface Finance {
    double calculateVat(double amount);
    double calculateTax(double amount);
}
