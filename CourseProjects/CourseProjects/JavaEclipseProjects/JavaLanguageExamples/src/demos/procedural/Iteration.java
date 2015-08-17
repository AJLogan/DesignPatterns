package demos.procedural;

public class Iteration {
	public static void main(String[] args) {
		showUnboundedIteration();
		showBoundedIteration();
	}
	private static void showUnboundedIteration() {
		System.out.println("--- While Loop ---");
		double value = 0;
		while(value < 0.75) {
			value = Math.random();
			System.out.println("\tNumber is: " + value);
		}
		System.out.println("--- Infinite While Loop ---");
		while(true) {
			value = Math.random();
			System.out.println("\tNumber is: " + value);
			if(value >= 0.75) {
				break;
			}
		}
		System.out.println("--- Do While Loop ---");
		do {
			value = Math.random();
			System.out.println("\tNumber is: " + value);
		} while(value < 0.75);
	}
	private static void showBoundedIteration() {
		System.out.println("--- For Loop Upwards---");
		for(int counter=0;counter<10;counter++) {
			System.out.println("\tLoop " + counter);
		}
		System.out.println("--- For Loop Downwards---");
		for(int counter=10;counter>0;counter--) {
			System.out.println("\tLoop " + counter);
		}
	}
}

