package demos.guava.functional;

public class Person {
	public Person(String name) {
		this.name = name;
	}
	public String toString() {
		return "Person called " + name;
	}
	private String name;
}
