package patterns.command.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new LinkedList<String>();
		Map<String,Command> commands = createCommandsMap(list,scanner);
		Command command = null;
		while(true) {
			printMenu();
			String choice = scanner.nextLine();
			if(choice.equals("undo")) {
				if(command != null) {
					command.undo();
				} else {
					System.out.println("Nothing to undo");
				}
			} else if(choice.equals("redo")) {
				if(command != null) {
					command.redo();
				} else {
					System.out.println("Nothing to redo");
				}
			} else {
				command = commands.get(choice);
				if(command == null) {
					System.out.println("No such command!");
				} else if(!command.execute()) {
					return;
				}
			}
			
		}
	} 
	private static Map<String, Command> createCommandsMap(List<String> list, Scanner scanner) {
		Map<String, Command> map = new HashMap<String, Command>();
		map.put("add",new AddCommand(list,scanner));
		map.put("get",new GetCommand(list,scanner));
		map.put("remove",new RemoveCommand(list,scanner));
		map.put("print",new PrintCommand(list,scanner));
		map.put("quit",new QuitCommand(list,scanner));
		return map;
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

