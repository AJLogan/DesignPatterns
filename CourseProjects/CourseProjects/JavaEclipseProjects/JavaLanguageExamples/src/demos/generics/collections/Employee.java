package demos.generics.collections;

class Employee {
	public Employee(String id, String name, double salary) {
		 super();
		 this.id = id;
		 this.name=name;
		 this.salary = salary;
	}
	public String toString() {
		  return name + " with ID " + id + " and salary " + salary;
	}
	private String id;
	private String name;
	private double salary;
}
