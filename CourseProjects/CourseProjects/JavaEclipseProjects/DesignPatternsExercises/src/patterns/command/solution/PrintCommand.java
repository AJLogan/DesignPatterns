package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public class PrintCommand extends Command {
	public PrintCommand(List<String> list, Scanner scanner) {
		super(list,scanner);
	}
	@Override
	public boolean execute() {
		System.out.println("Contents of list are: ");
		for(String str : list) {
			System.out.println("\t" + str); 
		}
		return true;
	}
	@Override
	public void redo() {
		execute();
	}
	@Override
	public void undo() {
		System.out.println("Sorry - print cannot be undone!");
	}
}
