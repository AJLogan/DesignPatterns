package demos.annotations.client;

import demos.annotations.testtool.TestRunner;

public class Tester {
	public static void main(String[] args) {
		TestRunner tr1 = new TestRunner(MyTestOne.class);
		TestRunner tr2 = new TestRunner(MyTestTwo.class);
		
		System.out.println("\n----- Finding Tests -----\n");
		
		tr1.printTestDetails(System.out);
		tr2.printTestDetails(System.out);
		
		System.out.println("\n----- Running Tests -----\n");
		
		tr1.runTests();
		tr2.runTests();
	}

}
