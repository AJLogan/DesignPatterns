package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public class AddCommand extends Command {
	public AddCommand(List<String> list, Scanner scanner) {
		super(list,scanner);
	}
	@Override
	public boolean execute() {
		System.out.println("Enter a string to add");
		item = scanner.nextLine();
		list.add(item);
		return true;
	}
	@Override
	public void redo() {
		list.add(item);
	}
	@Override
	public void undo() {
		list.remove(list.size() - 1);
	}
	private String item;
}
