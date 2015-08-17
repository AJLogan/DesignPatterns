package demos.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class DemoStringUtilities {
	public static void main(String[] args) {
		demoUsingJoiner();
		demoUsingSplitter();
	}
	private static void demoUsingSplitter() {
		Splitter s1 = Splitter.on(" , ").trimResults();
		Splitter s2 = Splitter.onPattern("[A-Z]{3}").limit(5);
		
		Iterable<String> iter1 = s1.split("ab , cd , ef , gh ,   ij  , kl");
		Iterable<String> iter2 = s2.split("abCDEfgHIJklMNOpqRSTuvWXYza");
		
		System.out.println("Result of first split:");
		for(String s : iter1) {
			System.out.printf("\t%s\n", s);
		}
		System.out.println("Result of second split:");
		for(String s : iter2) {
			System.out.printf("\t%s\n", s);
		}
	}
	private static void demoUsingJoiner() {
		Joiner j1 = Joiner.on(",").skipNulls();
		Joiner j2 = Joiner.on(":").useForNull("Foo");
		
		String result1 = j1.join("ab",null,"cd",null,"ef",null,"gh",null,null,"ij","kl");
		String result2 = j2.join("ab",null,"cd",null,"ef",null,"gh",null,null,"ij","kl");
		
		System.out.println("Joining strings produces:");
		System.out.printf("\t%s\n\t%s\n", result1, result2);
	}
}
