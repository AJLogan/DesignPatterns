package demos.tdd.testng.data.providers;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersAdvanced {
	private final Object[][] data1 = new Object[][] {
										{"12.3",2.3,10},
										{"34.5",4.5,30},
										{"56.7",6.7,50}
						  			   };
	private final Object[][] data2 = new Object[][] {
										{10, 2.3, "12.3"},
										{30, 4.5, "34.5"},
										{50, 6.7, "56.7"}
						  			  };
	@Test(dataProvider="myProviderA")
	public void op1(String str, double d, int i) {
		System.out.println("Test method op1 called with: " + str + " " + d + " and " + i);
		assertEquals(Double.parseDouble(str),d + i,2);
	}
	@Test(dataProvider="myProviderA")
	public void op2(int i, double d, String str) {
		System.out.println("Test method op2 called with: " + i + " " + d + " and " + str);
		assertEquals(Double.parseDouble(str),d + i,2);
	}
	@Test(dataProvider="myProviderB")
	public void op3(String str, double d, int i) {
		System.out.println("Test method op3 called with: " + str + " " + d + " and " + i);
		assertEquals(Double.parseDouble(str),d + i,2);
	}
	@Test(dataProvider="myProviderB")
	public void op4(int i, double d, String str) {
		System.out.println("Test method op4 called with: " + i + " " + d + " and " + str);
		assertEquals(Double.parseDouble(str),d + i,2);
	}
	@DataProvider(name="myProviderA")
	public Object[][] provider1(Method m) {
		if(m.getName().equals("op1")) {
			return data1;
		} else if(m.getName().equals("op2")) {
			return data2;
		} else {
			return null;
		}
	}
	@DataProvider(name="myProviderB")
	public Object[][] provider2(Method method, ITestContext context) {
		System.out.println("myProviderB called for " + method.getName() 
							+ " in suite " + context.getName());
		if(method.getName().equals("op3")) {
			return data1;
		} else if(method.getName().equals("op4")) {
			return data2;
		} else {
			return null;
		}
	}
}
