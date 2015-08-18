package patterns.command.start;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List<String> list = new LinkedList<String>();

		Map<String, Command> commands = new HashMap<String, Command>();
		commands.put("add", new AddCommand(scanner, list));
		commands.put("print", new GetCommand(scanner, list));
		commands.put("remove", new RemoveCommand(scanner, list));
		commands.put("undo", new UndoCommand(scanner, list));
		commands.put("redo", new RedoCommand(scanner, list));
		commands.put("quit", new QuitCommand(scanner, list));

		while (true) {
			printMenu();
			String choice = scanner.nextLine();

			Command current = commands.get(choice);
			if (current != null) {
				current.execute();
				continue;
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
