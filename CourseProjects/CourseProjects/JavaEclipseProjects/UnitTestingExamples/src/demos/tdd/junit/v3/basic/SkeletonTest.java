package demos.tdd.junit.v3.basic;

import junit.framework.TestCase;

public class SkeletonTest extends TestCase {
	public SkeletonTest() {
		System.out.printf("%s constructor called\n",getClass().getName());
	}
	protected void setUp() throws Exception {
		System.out.println("setUp called");
	}
	protected void tearDown() throws Exception {
		System.out.println("tearDown called");
	}
	public void testOne() {
		System.out.println("testOne called");
	}
	public void testTwo() {
		System.out.println("testTwo called");
	}
}
