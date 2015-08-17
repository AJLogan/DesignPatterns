package demos.boxing;

import java.util.Date;

public class SimpleBoxing {
	public static void main(String[] args) {
		Object [] stuff = new Object[6];
		stuff[0] = "ABC";
		stuff[1] = new Date();
		stuff[2] = 123;
		stuff[3] = 45.6;
		stuff[4] = 'c';
		stuff[5] = true;
		
		System.out.println("Types of objects in array are:");
		for(Object obj : stuff) {
			System.out.println("\t" + obj.getClass().getName());
		}
		
		int i = (Integer)stuff[2];
		double d = (Double)stuff[3];
		char c = (Character)stuff[4];
		boolean b = (Boolean)stuff[5];
		
		System.out.printf("Primitive types are %d %f %s and %s\n",i,d,c,b);
	}
}
