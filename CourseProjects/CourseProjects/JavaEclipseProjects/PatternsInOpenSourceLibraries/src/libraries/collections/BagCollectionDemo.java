package libraries.collections;

import java.util.*;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.*;

@SuppressWarnings({"rawtypes"})
public class BagCollectionDemo {

	public static void main(String[] args) {
		Bag bag = new TreeBag();
		populateBag(bag);
		printBagWithoutGrouping(bag);
		printBagWithGrouping(bag);
	}

	private static void printBagWithGrouping(Bag bag) {
		System.out.println("Bag contents with grouping:");
		Set groups = bag.uniqueSet();
		Iterator iter = groups.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println("There are " + bag.getCount(obj) + " copies of " + obj);
		}
	}

	private static void printBagWithoutGrouping(Bag bag) {
		System.out.println("Bag contents without grouping:");
		Iterator iter = bag.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("\n");
	}

	private static void populateBag(Bag bag) {
		for(char c = 'a', count=1; c <= 'z'; c++, count++) {
			for(int i=0;i<count;i++) {
				bag.add(new Character(c));
			}
		}
	}
}
