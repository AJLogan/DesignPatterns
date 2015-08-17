/*
 * Created on Sep 15, 2003
 *
 */
package demos.arrays;

/**
 * @author Garth Gilmour
 *
 */
public class Clock {

	private static final int[][] digitZero = {
												{0,1,1,1,1,1,0},
												{1,0,0,0,0,0,1},
												{1,0,0,0,0,0,1},
												{1,0,0,0,0,0,1},
												{1,0,0,0,0,0,1},
												{1,0,0,0,0,0,1},
												{1,0,0,0,0,0,1},
												{0,1,1,1,1,1,0}
											};

	private static final int[][] digitOne = {
												{0,0,0,0,1,0,0},
												{0,0,0,1,1,0,0},
												{0,0,1,0,1,0,0},
												{0,0,0,0,1,0,0},
												{0,0,0,0,1,0,0},
												{0,0,0,0,1,0,0},
												{0,0,0,0,1,0,0},
												{1,1,1,1,1,1,1}
											};

	private static final int[][] digitTwo = {
												{1,1,1,1,1,1,0},
												{0,0,0,0,0,0,1},
												{0,0,0,0,0,1,0},
												{0,0,0,0,1,0,0},
												{0,0,0,1,0,0,0},
												{0,0,1,0,0,0,0},
												{0,1,0,0,0,0,0},
												{1,1,1,1,1,1,1}
											};
											
	private static final int[][] digitThree = {
												{1,1,1,1,1,1,0},
												{0,0,0,0,0,0,1},
												{0,0,0,0,0,0,1},
												{0,0,1,1,1,1,0},
												{0,0,1,1,1,1,0},
												{0,0,0,0,0,0,1},
												{0,0,0,0,0,0,1},
												{1,1,1,1,1,1,0}
											};	
											
	private static final int[][] digitFour = {
												{0,0,0,0,1,0,0},
												{0,0,0,1,0,0,0},
												{0,0,1,0,1,0,0},
												{0,1,0,0,1,0,0},
												{1,1,1,1,1,1,0},
												{0,0,0,0,1,0,0},
												{0,0,0,0,1,0,0},
												{0,0,0,0,0,0,0}
											};	
													
	private static final int[][] digitFive = {
												{1,1,1,1,1,1,1},
												{1,0,0,0,0,0,0},
												{1,0,0,0,0,0,0},
												{0,1,0,0,0,0,0},
												{0,0,1,1,1,1,0},
												{0,0,0,0,0,0,1},
												{0,0,0,0,0,0,1},
												{1,1,1,1,1,1,0}
											};
											
	private static final int[][] digitSix = {
												{0,0,0,0,1,0,0},
												{0,0,0,1,0,0,0},
												{0,0,1,1,0,0,0},
												{0,1,0,0,1,0,0},
												{1,0,0,0,0,1,0},
												{0,1,0,0,0,1,0},
												{0,0,1,0,1,0,0},
												{0,0,0,1,0,0,0}
											};
												
	private static final int[][] digitSeven = {
												{1,1,1,1,1,1,1},
												{0,0,0,0,0,0,1},
												{0,0,0,0,0,1,0},
												{0,0,1,1,1,1,0},
												{0,0,0,1,0,0,0},
												{0,0,1,0,0,0,0},
												{0,1,0,0,0,0,0},
												{1,0,0,0,0,0,0}
											};
												
	private static final int[][] digitEight = {
												{0,0,0,1,0,0,0},
												{0,0,1,0,1,0,0},
												{0,1,0,0,0,1,0},
												{0,0,1,0,1,0,0},
												{0,0,1,0,1,0,0},
												{0,1,0,0,0,1,0},
												{0,0,1,0,1,0,0},
												{0,0,0,1,0,0,0}
											};
												
	private static final int[][] digitNine = {
												{1,1,1,1,1,1,0},
												{1,0,0,0,0,1,0},
												{1,0,0,0,0,1,0},
												{1,1,1,1,1,1,0},
												{0,0,0,0,0,1,0},
												{0,0,0,0,0,1,0},
												{0,0,0,0,0,1,0},
												{0,0,0,0,0,1,0}
											};
									
	private static int[][][] digits = {
										digitZero,
										digitOne,
										digitTwo,
										digitThree,
										digitFour,
										digitFive,
										digitSix,
										digitSeven,
										digitEight,
										digitNine
										
									};									
																								
	private static void printNumber(int[][] number) {
		for(int i=0;i<number.length;i++) {
			for(int x=0;x<number[i].length;x++) {
				if(number[i][x] == 1) {
					System.out.print('#');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int count = 0;
		while(true) {
			System.out.println("\n\n");
			printNumber(digits[count++]);
			if(count == digits.length) {
				count = 0;
			}
			try {
				Thread.sleep(500);
			}catch(Exception ex){}
		}
	}
}
