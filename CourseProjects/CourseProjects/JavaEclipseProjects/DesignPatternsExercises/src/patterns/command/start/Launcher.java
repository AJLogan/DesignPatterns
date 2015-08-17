package patterns.command.start;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List<String> list = new LinkedList<String>();
		while(true) {
			printMenu();
			String choice = scanner.nextLine();
			if(choice.equals("add")) {
				System.out.println("Enter a string to add");
				String item = scanner.nextLine();
				list.add(item);
			} else if(choice.equals("get")) {
				System.out.println("Enter an index");
				int index = scanner.nextInt();
				System.out.printf("Item at %d is %s\n",index,list.get(index));
			} else if(choice.equals("remove")) {
				System.out.println("Enter an index");
				int index = scanner.nextInt();
				System.out.printf("Item %s removed from position %d\n",list.remove(index),index);
			} else if(choice.equals("print")) {
				System.out.println("Contents of list are: ");
				for(String str : list) {
					System.out.println("\t" + str); 
				}
			} else if(choice.equals("undo")) {
				System.out.println("NOT IMPLEMENTED YET!");
			} else if(choice.equals("redo")) {
				System.out.println("NOT IMPLEMENTED YET!");
			} else if(choice.equals("quit"))  {
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
	private static void printMenu() {
		System.out.println("Choose an option:");
		System.out.println("\t [add] a string to the list");
		System.out.println("\t [get] a string at a specified position");
		System.out.println("\t [remove] a string from a specified position");
		System.out.println("\t [print] the current contents of the list");
		System.out.println("\t [undo] the last command");
		System.out.println("\t [redo] the last command");
		System.out.println("\t [quit] the program");
		System.out.println();
	}
}
