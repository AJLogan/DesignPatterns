package demos.procedural;

public class Overloading {

    public static void main(String[] args) {
    	//Overloaded for <int><int>
        int resultOne = addNumbers(4,5);
        System.out.println("Adding two integers produces: " + resultOne);
        //Overloaded for <double><double>
        double resultTwo = addNumbers(4.2,5.4);
        System.out.println("Adding two doubles produces: " + resultTwo);
        //Overloaded for <int><int><int>
        int resultThree = addNumbers(4,5,6);
        System.out.println("Adding three integers produces: " + resultThree);
        //Overloaded for <double><double><double>
        double resultFour = addNumbers(4.2,5.4,6.6);
        System.out.println("Adding three doubles produces: " + resultFour);
        //Overloaded for <int><double>
        double resultFive = addNumbers(4,5.6);
        System.out.println("Adding an int and a double produces: " + resultFive);
        //Overloaded for <double><int>
        double resultSix = addNumbers(5.6,4);
        System.out.println("Adding an double and a int produces: " + resultSix);
    }
    private static double addNumbers(double no1, double no2) {
        return no1 + no2;
    }
    private static int addNumbers(int no1,int no2) {
        return no1 + no2;
    }
    private static double addNumbers(double no1, double no2, double no3) {
        return no1 + no2 + no3;
    }
    private static int addNumbers(int no1,int no2, int no3) {
        return no1 + no2 + no3;
    }
    private static double addNumbers(int no1, double no2) {
        return no1 + no2;
    }
    private static double addNumbers(double no1, int no2) {
        return no1 + no2;
    }
}