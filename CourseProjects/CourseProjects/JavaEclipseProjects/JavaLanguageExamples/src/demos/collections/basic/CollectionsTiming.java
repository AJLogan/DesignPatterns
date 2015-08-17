package demos.collections.basic;

import java.util.*;

public class CollectionsTiming {
	public static void main(String[] args) {
		//time inserts
		System.out.println("Timing Insertions");
		timeLinkedListInsert();
		timeArrayListInsert();
		timeSynchronizedLinkedListInsert();
		timeSynchronizedArrayListInsert();

		//time removals
		System.out.println("\nTiming Removals");
		timeLinkedListRemove();
		timeArrayListRemove();
		timeSynchronizedLinkedListRemove();
		timeSynchronizedArrayListRemove();
	}
	public static void timeLinkedListInsert() {
		LinkedList<String> list = new LinkedList<String>();

		long startTime = System.currentTimeMillis();
		doListInserts(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Inserting into LinkedList took: " + (endTime - startTime));

	}
	public static void timeLinkedListRemove() {
		LinkedList<String> list = new LinkedList<String>();
		doListInserts(list);

		long startTime = System.currentTimeMillis();
		doListRemovals(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Removing from LinkedList took: " + (endTime - startTime));

	}
	public static void timeArrayListInsert() {
		ArrayList<String> list = new ArrayList<String>(INITIAL_CAPACITY);

		long startTime = System.currentTimeMillis();
		doListInserts(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Inserting into ArrayList took: " + (endTime - startTime));
	}
	public static void timeArrayListRemove() {
		ArrayList<String> list = new ArrayList<String>(INITIAL_CAPACITY);
		doListInserts(list);

		long startTime = System.currentTimeMillis();
		doListRemovals(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Removing from ArrayList took: " + (endTime - startTime));
	}
	public static void timeSynchronizedLinkedListInsert() {
		List<String> list = Collections.synchronizedList(new LinkedList<String>());

		long startTime = System.currentTimeMillis();
		doListInserts(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Inserting into synchronized LinkedList took: " + (endTime - startTime));
	}
	public static void timeSynchronizedLinkedListRemove() {
		List<String> list = Collections.synchronizedList(new LinkedList<String>());
		doListInserts(list);

		long startTime = System.currentTimeMillis();
		doListRemovals(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Removing from synchronized LinkedList took: " + (endTime - startTime));
	}
	public static void timeSynchronizedArrayListInsert() {
		List<String> list = Collections.synchronizedList(new ArrayList<String>());

		long startTime = System.currentTimeMillis();
		doListInserts(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Inserting into synchronized ArrayList took: " + (endTime - startTime));
	}
	public static void timeSynchronizedArrayListRemove() {
		List<String> list = Collections.synchronizedList(new ArrayList<String>(INITIAL_CAPACITY));
		doListInserts(list);

		long startTime = System.currentTimeMillis();
		doListRemovals(list);
		long endTime = System.currentTimeMillis();

		System.out.println("Removing from synchronized ArrayList took: " + (endTime - startTime));
	}
	public static void doListInserts(List<String> list){
		for(int i=0; i<ITERATIONS; i++) {
			list.add("str");
		}
	}
	public static void doListRemovals(List<String> list) {
		//remove 1000 elements from the start of the list
		for(int i=0; i<1000; i++) {
			list.remove(0);
		}
	}

	private static final int ITERATIONS = 100000;
	private static final int INITIAL_CAPACITY = 5000;
}
