package demos.reflection;

import java.lang.reflect.Method;

public class CallingMethodsOne {
	public static void main(String [] args) throws Exception {
		makeMethodCallsNormally();
		makeMethodCallsViaReflection();
	}
	private static void makeMethodCallsViaReflection() throws Exception {
		//Find the class object for TestClass (loading the class if required)
		Class<?> klass = Class.forName("demos.reflection.TestClass");
		//Each method takes a parameter of type String
		Class<?> [] parameters = new Class[] {String.class};
		//Find the methods
		Method m1 = klass.getDeclaredMethod("tst1",parameters);
		Method m2 = klass.getDeclaredMethod("tst2",parameters);
		Method m3 = klass.getDeclaredMethod("tst3",parameters);
		//Create an instance of the class
		Object instance = klass.newInstance();
		//Make the calls via the method objects
		System.out.println("Method calls made via reflection:");
		System.out.println("\t" + m1.invoke(instance, new Object[] {"abc"}));
		System.out.println("\t" + m2.invoke(instance, new Object[] {"def"}));
		System.out.println("\t" + m3.invoke(instance, new Object[] {"ghi"}));
	}
	private static void makeMethodCallsNormally() {
		System.out.println("Method calls made normally:");
		TestClass tc = new TestClass();
		System.out.println("\t" + tc.tst1("abc"));
		System.out.println("\t" + tc.tst2("def"));
		System.out.println("\t" + tc.tst3("ghi"));
	}
}
