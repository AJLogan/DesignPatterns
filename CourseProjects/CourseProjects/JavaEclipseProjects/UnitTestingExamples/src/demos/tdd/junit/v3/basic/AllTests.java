package demos.tdd.junit.v3.basic;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test of JUnit 3");
		suite.addTestSuite(MathTest.class);
		suite.addTestSuite(SkeletonTest.class);
		return suite;
	}

}
