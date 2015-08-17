package demos.procedural;

public class Variables {

    //class variables are initialized by the VM
    //static class variables only have a single instance
    // which is initialized when the class is loaded
	private static short s;

	public static void main(String[] args) {
		int i;

		//local variables must be initialized
		// before their first use
		if (Math.random() > 0.5) {
			i = 27;
		} else {
			i = 12;
		}

		float f = 1.2F;

		//automatic conversion
		double result = f * i;

		//example of a cast
		s = (short) result;

		System.out.println("The result is: " + result);
		System.out.println("The value in s is: " + s);
	}
}