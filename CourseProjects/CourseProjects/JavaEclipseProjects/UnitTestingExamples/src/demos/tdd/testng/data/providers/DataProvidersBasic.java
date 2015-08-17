package demos.tdd.testng.data.providers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DataProvidersBasic {
	@Test(dataProvider="myProvider")
	public void op1(String str, double d, int i) {
		System.out.println("Test method called with: " + str + " " + d + " and " + i);
		assertEquals(Double.parseDouble(str),d + i,2);
	}
	@DataProvider(name="myProvider")
	public Object[][] op2() {
		return new Object[][] {
									{"12.3",2.3,10},
									{"34.5",4.5,30},
									{"56.7",6.7,50}
							  };
	}
}
