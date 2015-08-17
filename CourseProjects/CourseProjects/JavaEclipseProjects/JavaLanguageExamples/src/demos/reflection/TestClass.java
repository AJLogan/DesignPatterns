package demos.reflection;

public class TestClass {
	public TestClass() {
		System.out.println("Default constructor");
	}
	public TestClass(String str) {
		System.out.println("One arg constructor called with " + str);
	}
	public TestClass(String str, StringBuffer buffer) {
		System.out.println("Two arg constructor called with " + str + " and " + buffer);
	}
	public String tst1(String param) {
		return "Hello from TestClass function one: parameter is - " + param;
	}
	public String tst2(String param) {
		return "Hello from TestClass function two: parameter is - " + param;
	}
	public String tst3(String param) {
		return "Hello from TestClass function three: parameter is - " + param;
	}
	public String toString() {
		return "Some TestClass object...";
	}
}
