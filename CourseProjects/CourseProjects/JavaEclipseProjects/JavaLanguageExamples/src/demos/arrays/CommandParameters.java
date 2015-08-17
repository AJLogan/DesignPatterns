package demos.arrays;

public class CommandParameters {

	public static void main(String[] args) {
		System.out.println("Command Line Parameters Are: ");
		for(int i=0;i<args.length;i++) {
			System.out.println("\tArgument " + i + " is " + args[i]);
		}
	}
}

