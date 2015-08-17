package demos.varargs;

import java.util.Date;

public class VariableArgumentsPlusBoxing {

	public static void main(String[] args) {
		printf("Test 1 - values are %s, %s and %s",12,2.3,false);
		printf("Test 2 - values are %s, %s and %s","abc",'s',new Date());
	}
	private static void printf(String msg, Object ... args) {
		for(int i=0;i<args.length;i++) {
			msg = msg.replaceFirst("%s",args[i].toString());
		}
		System.out.println(msg);
	}

}
