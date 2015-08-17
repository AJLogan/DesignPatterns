package demos.fp.monads.option.extra;

import java.util.Optional;

public class Employee {
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public Paycheck paycheck() {
        if(salary > 0) {
            return new Paycheck(salary);
        } else {
            return null;
        }
    }
    public Paycheck nullablePaycheck() {
        if(salary > 0) {
            return new Paycheck(salary);
        } else {
            return new NullPaycheck();
        }
    }
    public Optional<Paycheck> optionalPaycheck() {
        if(salary > 0) {
            return Optional.of(new Paycheck(salary));
        } else {
            return Optional.empty();
        }
    }
    
    @Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	private String name;
    private double salary;
}
