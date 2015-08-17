package roman.numerals.finish.ok;

import java.util.Scanner;

public class Exercise {
	static {
		createMap();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the number (non number to end)");
			if (input.hasNextInt()) {
				int val = input.nextInt();
				System.out.println(convert(val));
			} else {
				System.out.print("Byeee...");
				break;
			}
		}
	}
	private static void createMap() {
		numerals = new Numeral[9];
		numerals[0] = new Numeral(100, "C");
		numerals[1] = new Numeral(90, "XC");
		numerals[2] = new Numeral(50, "L");
		numerals[3] = new Numeral(40, "XL");
		numerals[4] = new Numeral(10, "X");
		numerals[5] = new Numeral(9, "IX");
		numerals[6] = new Numeral(5, "V");
		numerals[7] = new Numeral(4, "IV");
		numerals[8] = new Numeral(1, "I");
	}
	static String convert(int number) {
		String result = "";
		for (Numeral numeral : numerals) {
			int times = number / numeral.getValue();
			if(times > 0) {
				for(int i=0;i<times;i++) {
					result += numeral.getNumeral();
				}
			}
			number = number % numeral.getValue();
		}
		return result;
	}
	private static Numeral[] numerals;
}
