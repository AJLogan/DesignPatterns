package demos.strings;

public class InternDemo {
	public static void main(String[] args) {
		System.out.println("\ndemonstrating use of intern");
		String s1 = new String("abc");
		String s2 = "abc";
		testStrings(s1.intern(),s2);
	}
	private static void testStrings(String p1, String p2) {
		if(p1 == p2) {
			System.out.println("p1 ref equals p2 ref");
		}
		else {
			System.out.println("p1 ref does not equal p2 ref");
		}
		if(p1.equals(p2)) {
			System.out.println("p1 content equals p2 content");
		}
		else {
			System.out.println("p1 content does not equal p2 content");
		}
	}
}
