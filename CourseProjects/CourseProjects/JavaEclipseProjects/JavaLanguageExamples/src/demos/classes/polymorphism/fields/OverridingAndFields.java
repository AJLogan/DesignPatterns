package demos.classes.polymorphism.fields;

/**
 * @author Garth Gilmour
 * 
 *	A common source of bugs in Java relates to the interaction between
 *	 members and methods in inheritance trees.
 *	If two variables (e.g. String s) with the same name and type are
 *	 declared in base and derived classes then overridden methods will
 *	 work with the variable declared at the same level.
 */
public class OverridingAndFields {
	public static void main(String[] args) {

		Base b = new Base();
		System.out.println(b.test());
		Derived d = new Derived();
		System.out.println(d.test());
		Base b2 = new Derived();
		System.out.println(b2.test());
	}
}


class Base extends Object {

	public String test() {
		return s;
	}
	String s = "Hello I'm Base";
}


class Derived extends Base {

	//public String test() {
	//	return s;
	//}
	String s = "Hello I'm Derived";
}
