package demos.generics.extra;

public class Tester {
	public static void main(String[] args) {
		Pair<Integer,Double> tst1 = new Pair<Integer,Double>(1,2.3);
		Pair<Integer,Double> tst2 = new Pair<Integer,Double>(4,5.6);
		Pair<Integer,String> tst3 = new Pair<Integer,String>(4,"abc");
		Pair<String, Double> tst4 = new Pair<String,Double>("def",5.6);
		
		boolean r1 = haveSameFirst(tst1,tst3);
		boolean r2 = haveSameFirst(tst2,tst3);
		boolean r3 = haveSameSecond(tst2,tst4);
		boolean r4 = haveSameSecond(tst1,tst4);
		
		System.out.printf("First results are %b, %b, %b and %b\n",r1,r2,r3,r4);
		
		Pair<String,Character> tst5 = new Pair<String,Character>("ab",'x');
		Pair<String,Character> tst6 = new Pair<String,Character>("cd",'y');
		Pair<String,Character> tst7 = new Pair<String,Character>("ef",'x');
		
		boolean r5 = isLarger(tst5,tst6);
		boolean r6 = isLarger(tst6,tst5);
		boolean r7 = isLarger(tst6,tst7);
		
		System.out.printf("Second results are %b, %b and %b\n",r5,r6,r7);
	}
	private static <T> boolean haveSameFirst(Pair<T,?> p1, Pair<T,?> p2) {
		return p1.getFirst().equals(p2.getFirst());
	}
	private static <T> boolean haveSameSecond(Pair<?,T> p1, Pair<?,T> p2) {
		return p1.getSecond().equals(p2.getSecond());
	}
	private static <T extends Comparable<T>, U extends Comparable<U>> boolean isLarger(Pair<T,U> p1, Pair<T,U> p2) {
		if(p1.getFirst().compareTo(p2.getFirst()) > 0) {
			if(p1.getSecond().compareTo(p2.getSecond()) > 0) {
				return true;
			}
		}
		return false;
	}
}
