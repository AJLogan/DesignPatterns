package demos.printf;

import java.util.Date;

public class Demo {
	public static void main(String[] args) {
		//Show printing values, with and without numbers
		System.out.printf("1: Values are %1$s, %2$s and %3$s\n","test1","test2","test3");
		System.out.printf("2: Values are %s, %s and %s\n","test1","test2","test3");
		//Show printing numbered values in reverse
		System.out.printf("3: Values are %3$s, %2$s and %1$s\n","test1","test2","test3");
		//Show precision for floating point values
		System.out.printf("4: Values are\n\t %1$.4f\n\t %2$.4f\n\t %3$.4f\n\t %4$.4f\n",1.2,1.23,1.234,1.2345);
		//Show displaying times in 24hr and 12hr
		Date now = new Date();
		System.out.printf("5: The time is %1$tT or %2$tr if you prefer\n",now,now);
		//Show displaying dates
		System.out.printf("6: The date is %1$tD or %2$tF if you prefer\n",now,now);
		//Show displaying integers in different formats
		int no1 = 100;
		int no2 = 256;
		int no3 = 1024;
		System.out.printf("7: Numbers in decimal are %1$d, %2$d and %3$d\n",no1,no2,no3);
		System.out.printf("8: Numbers in octal are %1$o, %2$o and %3$o\n",no1,no2,no3);
		System.out.printf("9: Numbers in hex are %1$x, %2$x and %3$x\n",no1,no2,no3);	
	}
}
