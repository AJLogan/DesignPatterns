package demos.arrays;

import demos.classes.inheritance.Employee;
import demos.classes.inheritance.Manager;

public class ArraysOfObjects {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Joe",40,15000);
        employees[1] = new Manager("Fred",35,20000,"IT",500000);
        employees[2] = new Employee("Dave",18,25000);
        employees[3] = new Manager("Gordon",26,30000,"HR",300000);
        employees[4] = new Employee("Simon",54,19000);
        printArrayOfEmployee(employees);
        raiseMorale(employees);
        printArrayOfEmployee(employees);
    }
    public static void raiseMorale(Employee[] input) {
        for(int i=0;i<input.length;i++) {
            input[i].awardBonus(500);
        }
    }
    private static void printArrayOfEmployee(Employee[] input) {
        System.out.println("All employees are:");
        for(int i=0;i<input.length;i++) {
            System.out.println("\t" + input[i]);
        }
    }
}

