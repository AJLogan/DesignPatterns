package demos.fp.monads.option.extra;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        try {
            System.out.println(calculateTotalPayrollV1());
        } catch (NullPointerException ex) {
            System.out.println("Null pointer error!");
        }
        System.out.println(calculateTotalPayrollV2());
        System.out.println(calculateTotalPayrollV3());
        System.out.println(calculateTotalPayrollV4());
    }

    private static double calculateTotalPayrollV1() {
        double totalSalary = 0;
        for (Employee emp : buildListOfStaff()) {
            Paycheck p = emp.paycheck();
            totalSalary += p.basicWage();
            if (p.eligibleForPerformanceBonus()) {
                totalSalary += p.calcBonus();
            }
        }
        return totalSalary;
    }
    private static double calculateTotalPayrollV2() {
        double totalSalary = 0.0;
        for (Employee emp : buildListOfStaff()) {
            Paycheck p = emp.nullablePaycheck();
            totalSalary += p.basicWage();
            if (p.eligibleForPerformanceBonus()) {
                totalSalary += p.calcBonus();
            }
        }
        return totalSalary;
    }
    private static double calculateTotalPayrollV3() {
        double totalSalary = 0.0;
        for (Employee emp : buildListOfStaff()) {
            Optional<Paycheck> option = emp.optionalPaycheck();
            Paycheck p = option.orElse(new NullPaycheck());
            totalSalary += p.basicWage();
            if (p.eligibleForPerformanceBonus()) {
                totalSalary += p.calcBonus();
            }
        }
        return totalSalary;
    }
    private static double calculateTotalPayrollV4() {
        class Accumulator {
            double value = 0;
            void calc(Paycheck p) {
                double salary = p.basicWage();
                if (p.eligibleForPerformanceBonus()) {
                    salary += p.calcBonus();
                }
                value +=  salary;
            }
        }
        Accumulator a = new Accumulator();
        buildListOfStaff().stream().forEach(e -> e.optionalPaycheck().ifPresent(a::calc));
        return a.value;
    }
    private static List<Employee> buildListOfStaff() {
        List<Employee> staff = new LinkedList<>();
        staff.add(new Employee("Dave", 40000.0));
        staff.add(new Employee("Jane", 50000.0));
        staff.add(new Employee("Pete", 0.0));
        staff.add(new Employee("Mary", 20000.0));
        staff.add(new Employee("Sean", 15000.0));

        return staff;
    }
}
