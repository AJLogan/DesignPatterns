package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public class RemoveCommand extends Command {
	public RemoveCommand(List<String> list, Scanner scanner) {
		super(list,scanner);
	}
	@Override
	public boolean execute() {
		System.out.println("Enter an index");
		index = scanner.nextInt();
		item = list.remove(index);
		System.out.printf("Item %s removed from position %d\n",item,index);
		return true;
	}
	@Override
	public void redo() {
		item = list.remove(index);
	}
	@Override
	public void undo() {
		list.add(index,item);
	}
	private int index;
	private String item;
}
