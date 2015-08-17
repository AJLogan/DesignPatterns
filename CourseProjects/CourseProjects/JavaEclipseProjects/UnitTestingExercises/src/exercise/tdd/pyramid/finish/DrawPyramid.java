package exercise.tdd.pyramid.finish;

import java.io.PrintStream;

public class DrawPyramid {
	public static void main(String[] args) {
	    printPyramid(System.out,20);
    }
    static void printPyramid(PrintStream output, final int size) {
        //the number of hashes to be printed in the current row
        int numHashes = 1;
        //for each row in the pyramid...
        for (int rows = 1; rows <= size; rows++) {
            int spaces = size - rows;
            printRow(output, numHashes, spaces);
            //adjust the number of hashes
            numHashes += 2;
        }
    }
    private static void printRow(PrintStream output, int numHashes, int spaces) {
        //print the correct number of spaces
    	while (spaces > 0) {
            output.print(" ");
            spaces--;
        }
        //print the correct number of hashes
        for (int hashes = 0; hashes < numHashes; hashes++) {
            output.print("#");
        }
        //take a new line
        output.println();
    }
}
