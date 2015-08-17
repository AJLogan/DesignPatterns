package demos.arrays;

public class ArraysOfBasicTypes {

    public static void main(String[] args) {
        //One way to declare an array
        int[] intArrayOne = new int[5];
        intArrayOne[0] = 101;
        intArrayOne[1] = 202;
        intArrayOne[2] = 303;
        intArrayOne[3] = 404;
        intArrayOne[4] = 505;
        //Declaring an array of literals
        int [] intArrayTwo = new int[]{1001,1002,1003};
        int [] intArrayThree = {2001,2002,2003,2004};
        //Print the arrays
        printArrayOfInt(intArrayOne);
        printArrayOfInt(intArrayTwo);
        printArrayOfInt(intArrayThree);
        //Guaranteed to throw ArrayIndexOutOfBounds exception
        //int tmp = intArrayOne[intArrayOne.length];
    }

    private static void printArrayOfInt(int[] input) {
        System.out.println("------------------");
        System.out.println("First element is: " + input[0]);
        System.out.println("Last element is: " + input[input.length - 1]);
        System.out.println("Full contents are:");
        for(int i=0;i<input.length;i++) {
            System.out.println("\t" + input[i]);
        }
    }
}

