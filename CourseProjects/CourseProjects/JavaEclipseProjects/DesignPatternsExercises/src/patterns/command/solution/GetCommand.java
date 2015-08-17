package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public class GetCommand extends Command {
	public GetCommand(List<String> list, Scanner scanner) {
		super(list,scanner);
	}
	@Override
	public boolean execute() {
		System.out.println("Enter an index");
		index = scanner.nextInt();
		System.out.printf("Item at %d is %s\n",index,list.get(index));
		return true;
	}
	@Override
	public void redo() {
		System.out.printf("Item at %d is %s\n",index,list.get(index));
	}
	@Override
	public void undo() {
		System.out.println("Sorry - get cannot be undone!");
	}
	private int index;
}
