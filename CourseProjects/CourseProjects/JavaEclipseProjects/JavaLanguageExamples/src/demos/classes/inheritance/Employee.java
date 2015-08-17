package demos.classes.inheritance;

public class Employee extends Object {
    public Employee(String name, int age, double salary) {
    	this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return getClass().getName() + " called " + name
        		+ " of age " + age + " earning " + salary;
    }
    public void awardBonus(double bonus) {
        salary += bonus;
    }
    public void awardBonus() {
        awardBonus(500);
    }
    private String name;
    private int age;
    private double salary;
}
