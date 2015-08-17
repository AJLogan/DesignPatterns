package demos.tdd.junit.v4.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SkeletonTest {
	public SkeletonTest() {
		System.out.printf("%s constructor called\n",getClass().getName());
	}
	@BeforeClass
	public static void startAll() {
		System.out.println("@BeforeClass called");
	}
	@AfterClass
	public static void afterAll() {
		System.out.println("@AfterClass called");
	}
	@Before
	public void start() {
		System.out.println("@Before called");
	}
	@After
	public void end() {
		System.out.println("@After called");
	}
	@Test
	public void op1() {
		System.out.println("@Test method op1 called");
	}
	@Test
	@Ignore
	public void op2() {
		System.out.println("@Test method op2 called");
	}
}
