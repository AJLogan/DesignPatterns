package demos.staticimport.one;

import static demos.staticimport.two.MyConstants.*;

public class Tester {

	public static void main(String[] args) {
		System.out.println(MAX_THREADS);
		System.out.println(SERVER_IP);
		System.out.println(op1());
		System.out.println(op2());
	}

}
