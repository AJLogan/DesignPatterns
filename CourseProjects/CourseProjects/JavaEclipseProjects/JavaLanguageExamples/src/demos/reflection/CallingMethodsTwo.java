package demos.reflection;

import java.lang.reflect.*;
import java.io.*;

/*
		Reads in the (fully qualified) name of a class from the command line and
		 attempts to load it using 'forName'.
		The names of all the methods in the class are then printed, along with their
		 parameters and return types.
		The user can then enter a method name and a single parameter, which is used to
		 create a Method object and thereby make a function call.
		Try and extend this class to cope with two or more parameters.
*/

public class CallingMethodsTwo {
	private static BufferedReader reader;
	
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) throws Exception {
		Class<?> klass = loadClass();
		printMethods(klass);
		makeMethodCall(klass);
	}
	public static Class<?> loadClass() throws ClassNotFoundException, IOException {
		System.out.println("Enter class name:");
		String className = reader.readLine();
		return Class.forName(className);
	}
	public static void printMethods(Class<?> klass) {
		System.out.println("\nAvailable methods are::");
		Method[] m = klass.getDeclaredMethods();
		for(int i=0; i<m.length; i++) {
			String s = new String("\t" + m[i].getName() + " returning " + m[i].getReturnType());
			s += " with Parameters: ";
			Class<?>[] c = m[i].getParameterTypes();
			for(int z=0; z<c.length; z++) {
				s += (" " + c[z].getName());
			}
			System.out.println(s);
		}
	}
	private static void makeMethodCall(Class<?> klass) throws Exception {
		System.out.println("\nEnter method:");
		String method = reader.readLine();
		System.out.println("\nEnter parameter:");
		String parameter = reader.readLine();
		System.out.println(callMethod(klass, method,parameter));
	}
	public static String callMethod(Class<?> klass, String name, String parameter) throws Exception {
		Method m = klass.getDeclaredMethod(name,new Class[] { Class.forName("java.lang.String") });
		Object obj = klass.newInstance();
		return (String)m.invoke(obj,new Object[] {parameter});
	}
}
