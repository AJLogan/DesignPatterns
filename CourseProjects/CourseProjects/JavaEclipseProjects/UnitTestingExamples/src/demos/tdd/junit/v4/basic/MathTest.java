package demos.tdd.junit.v4.basic;

import org.junit.*;
import static org.junit.Assert.*;


public class MathTest {
	@Before
	public void start() {
		math = new Math(21, 5);
	}
	@Test
	public void add() {
		assertTrue("Add failed", math.add() == 26);
	}
	@Test
	public void subtract() {
		assertEquals("Subtract failed", 16, math.subtract());
	}
	@Test
	public void multiply() {
		assertEquals("Multiply failed", 105, math.multiply());
	}
	@Test(expected=IllegalArgumentException.class)
	public void exceptionOnFirstArg() {
			new Math(0, 10);
	}
	@Test(expected=IllegalArgumentException.class)
	public void exceptionOnSecondArg() {
			new Math(10, 0);
	}
	private Math math;
}
