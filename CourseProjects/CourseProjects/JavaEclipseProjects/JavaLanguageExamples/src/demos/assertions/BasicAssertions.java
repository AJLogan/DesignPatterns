package demos.assertions;

/**
 * @author Garth Gilmour
 *
 * Remember to use assertions you must:
 *	  1) Compile with 'javac -source 1.4'
 *	  2) Run with 'java -ea'
 *
 */

public class BasicAssertions {

	public static void main(String[] args) {
		
		int resultOne = SimpleMath.add(2,2);
		assert 4 == resultOne;
		
		double resultTwo = SimpleMath.divide (9,3);
		assert 3 == resultTwo;

		double resultThree = SimpleMath.divide(11,2);
		assert 5.5 == resultThree : "cannot handle fractions";
	}
}

class SimpleMath {
	static int add(int a, int b) {
			return a + b;
	}
	static int divide(int a, int b) {
			return a / b;
	}

}
