/*
 * Created on Sep 16, 2003
 *
 */
package demos.generics.list;

/**
 * @author Garth Gilmour
 *
 */
public class Launcher {

	public static void main(String[] args) {
		showListForString();
		showListForInteger();
	}

	private static void showListForString() {
		System.out.println("\n----- showListForString -----\n");
		
		List<String> list = new LinkedList<String>();

		try {
			//list.remove("jkl");

			list.add("abc");
			list.add("def");
			list.add("ghi");
			list.add("jkl");
			list.add("mno");
			list.add("pqr");


			System.out.println(list.toString());

			list.remove("jkl");

			System.out.println(list.toString());

			//list.remove("zzz");

		} catch(ListEmptyException ex) {
			System.out.println(ex);
		} catch(ItemNotInListException ex) {
			System.out.println(ex);
		} finally {
			System.out.println("In FINALLY");
		}
	}
	private static void showListForInteger() {
		System.out.println("\n----- showListForInteger -----\n");
		
		List<Integer> list = new LinkedList<Integer>();

		try {
			//list.remove(909);

			list.add(101);
			list.add(202);
			list.add(303);
			list.add(404);
			list.add(505);
			list.add(606);


			System.out.println(list.toString());

			list.remove(606);

			System.out.println(list.toString());

			//list.remove(909);

		} catch(ListEmptyException ex) {
			System.out.println(ex);
		} catch(ItemNotInListException ex) {
			System.out.println(ex);
		} finally {
			System.out.println("In FINALLY");
		}
	}
}
