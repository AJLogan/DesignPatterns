package demos.accessibility;

//public classes can be seen outside the package - only one per '.java' file
public class AccessDemo {
	public static void main(String[] args) {

		//OK - MyClass is part of the current package
		MyClass mc = new MyClass();

		//OK - op1 is public
		mc.op1();

		//OK - op2 is protected and we are in the same package
		// (note the difference from C++)
		mc.op2();

		//OK - op3 has default accessability and we are in the same package
		mc.op3();

		//ERROR - op4 is private
		//mc.op4();

		//ERROR - Inner is a private inner class
		//MyClass.Inner demo = new MyClass().new Inner();
	}
}
//class with default accessability - many per '.java' file
// top level classes cannot be protected or private
class MyClass {

	//public methods are seen from client code
	// they are part fo the classes interface
	public void op1(){}

	//protected methods are seen from the current package
	// and by classes that inherit from us
	protected void op2(){}

	//default (package) methods are accessable
	// from the current package only
	void op3(){}

	//private methods cannot be seen outside
	// of the declaring class
	@SuppressWarnings("unused")
	private void op4(){}

	//inner classes can have any accessability
	@SuppressWarnings("unused")
	private class Inner {}
}
