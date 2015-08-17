package demos.swing.tables.advanced;

public class Employee {
	public Employee(String name, String dept, int age, double salary, boolean onLeave) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.salary = salary;
		this.onLeave = onLeave;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isOnLeave() {
		return onLeave;
	}
	public void setOnLeave(boolean onLeave) {
		this.onLeave = onLeave;
	}
	private String name;
	private String dept;
	private int age;
	private double salary;
	private boolean onLeave;
}
