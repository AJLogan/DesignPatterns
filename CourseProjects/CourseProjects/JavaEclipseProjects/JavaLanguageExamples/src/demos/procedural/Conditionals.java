package demos.procedural;

public class Conditionals {

	public static void main(String[] args) {
		double value  = Math.random();
		showIfStatement(value);
		showSwitchStatement(value);
	}
	private static void showSwitchStatement(double value) {
		int oneToTen = (int)(value * 10) + 1;
		switch(oneToTen) {
			case 1:
				System.out.println("Int is one");
				break;
			case 3:
			case 5:
				System.out.println("Int is three or five");
				break;
			case 7:
				System.out.println("Int is seven");
				break;
			case 9:
				System.out.println("Int is nine");
				break;
			default:
				System.out.println("Int is " + oneToTen);	
		}
	}
	private static void showIfStatement(double value) {
		System.out.println("Value is: " + value);
		if(value < 0.25) {
			System.out.println("Less than .25");
		} else if(value < 0.5) {
			System.out.println("Less than .5");
		} else if(value < 0.75) {
			System.out.println("Less than .75");
		} else {
			System.out.println("Less than 1");
		}
	}
}
