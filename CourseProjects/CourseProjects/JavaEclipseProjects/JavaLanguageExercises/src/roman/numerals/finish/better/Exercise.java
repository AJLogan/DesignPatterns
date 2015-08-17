package roman.numerals.finish.better;

import java.util.Scanner;

public class Exercise {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the number (non number to end)");
			if (input.hasNextInt()) {
				int val = input.nextInt();
				String result = convert(val);
				System.out.println(result);
			} else {
				System.out.print("Byeee...");
				break;
			}
		}
	}
	static String convert(int val) {
		String result = "";
		for(Numeral numeral : Numeral.numerals) {
			result += numeral.apply(val);
			val = numeral.remainder(val);
		}
		return result;
	}

}
