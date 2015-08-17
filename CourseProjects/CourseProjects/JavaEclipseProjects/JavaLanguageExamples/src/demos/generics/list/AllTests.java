package demos.generics.list;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for demos.generics.list");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestListForInteger.class);
		suite.addTestSuite(TestListForString.class);
		//$JUnit-END$
		return suite;
	}

}
