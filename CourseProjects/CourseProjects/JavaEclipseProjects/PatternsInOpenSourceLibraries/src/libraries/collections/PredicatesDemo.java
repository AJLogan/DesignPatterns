package libraries.collections;

import java.util.*;

import org.apache.commons.collections.*;
import org.apache.commons.collections.functors.*;

@SuppressWarnings({"rawtypes","unchecked"})
public class PredicatesDemo {

	public static void main(String[] args) {
		demoInstanceofPredicate();
		demoOrPredicateUsingEqualsAndIdentity();
	}
	private static void demoInstanceofPredicate() {
		demoInstanceofPredicateForStrings();
		demoInstanceofPredicateForIntegers();
	}
	private static void demoOrPredicateUsingEqualsAndIdentity() {
		List testList = buildStringsAndIntegersList();
		Predicate p = buildOrPredicate();
		CollectionUtils.filter(testList,p);
		printCollection(testList,"OrPredicate Using Equals and Identity");
	}
	private static Predicate buildOrPredicate() {
		Predicate p1 = EqualPredicate.getInstance(new Integer(70));
		Predicate p2 = IdentityPredicate.getInstance("fghi");
		return OrPredicate.getInstance(p1,p2);
	}
	private static void demoInstanceofPredicateForStrings() {
		List testList = buildStringsAndIntegersList();
		Predicate p = InstanceofPredicate.getInstance(String.class);
		CollectionUtils.filter(testList,p);
		printCollection(testList,"InstanceofPredicate Filtering for Strings");
	}
	private static void demoInstanceofPredicateForIntegers() {
		List testList = buildStringsAndIntegersList();
		Predicate p = InstanceofPredicate.getInstance(Integer.class);
		CollectionUtils.filter(testList,p);
		printCollection(testList,"InstanceofPredicate Filtering for Integers");
	}
	private static void printCollection(Collection c, String title) {
		System.out.println("\n----- Start of " + title + " -----");
		Iterator i = c.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("----- End of " + title + " -----\n");
	}
	private static List buildStringsAndIntegersList() {
		List list = new ArrayList();
		list.add("ab");
		list.add(new Integer(20));
		list.add("cde");
		list.add(new Integer(30));
		list.add("fghi");
		list.add(new Integer(40));
		list.add("jklmo");
		list.add(new Integer(50));
		list.add("opqrst");
		list.add(new Integer(60));
		list.add("uvwxyza");
		list.add(new Integer(70));
		list.add("bcdefghi");
		list.add(new Integer(80));
		return list;
	}
}
