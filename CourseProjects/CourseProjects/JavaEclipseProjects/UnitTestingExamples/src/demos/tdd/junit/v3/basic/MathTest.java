package demos.tdd.junit.v3.basic;

import junit.framework.*;

public class MathTest extends TestCase {
	protected void setUp() throws Exception {
		math = new Math(21, 5);
	}
	public void testAdd() {
		assertTrue("Add failed", math.add() == 26);
	}
	public void testSubtract() {
		assertEquals("Subtract failed", 16, math.subtract());
	}
	public void testMultiply() {
		assertEquals("Multiply failed", 105, math.multiply());
	}
	public void testException() {
		try {
			new Math(10, 0);
			fail("Exception not thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
		try {
			new Math(0, 10);
			fail("Exception not thrown");
		} catch (IllegalArgumentException ex) {
			// Expected
		}
	}
	private Math math;
}
