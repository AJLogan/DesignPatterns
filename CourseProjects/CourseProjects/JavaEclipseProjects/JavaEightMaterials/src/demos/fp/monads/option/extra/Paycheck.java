package demos.fp.monads.option.extra;

public class Paycheck {
    public Paycheck(double salary) {
        this.salary = salary;
    }
    public boolean eligibleForPerformanceBonus() {
        return salary < 30000.0;
    }
    public double basicWage() {
        return salary / 12;
    }
    public double calcBonus() {
        return salary / 10;
    }
    private double salary;
}
