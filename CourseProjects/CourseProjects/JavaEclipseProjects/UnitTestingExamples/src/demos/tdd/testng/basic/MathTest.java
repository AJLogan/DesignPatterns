package demos.tdd.testng.basic;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class MathTest {
	@BeforeMethod
	public void start() {
		System.out.println("---->start called");
		math = new Math(12,5);
	}
	@AfterMethod
	public void end() {
		System.out.println("---->end called");
	}
	@Test
	public void add() {
		System.out.println("------>add called");
		assertEquals(17,math.add(),"Add failed");
	}
	@Test
	public void subtract() {
		System.out.println("------>subtract called");
		assertEquals(7,math.subtract(),"Subtract failed");
	}
	@Test
	public void multiply() {
		System.out.println("------>multiply called");
		assertEquals(60,math.multiply(),"Multiply failed");
	}
	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void exceptionOnFirstArg() {
		System.out.println("------exceptionOnFirstArg called");
		new Math(10, 0);
	}
	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void exceptionOnSecondArg() {
		System.out.println("------>exceptionOnSecondArg called");
		new Math(0, 10);
	}
	@Parameters({ "paramOne","paramTwo","result" })
	@Test
	public void parametersFromXml(int paramOne, int paramTwo, int result) {
		System.out.printf("------>parametersFromXml called with %d, %d and %d\n", paramOne, paramTwo, result);
		new Math(paramOne, paramTwo);
		assertEquals(math.add(),result,"Add failed");
	}
	private Math math;
}
