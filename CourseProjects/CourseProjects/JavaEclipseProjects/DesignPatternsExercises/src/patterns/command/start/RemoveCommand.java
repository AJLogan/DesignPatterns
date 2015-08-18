package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class RemoveCommand extends Command  {

	public RemoveCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("Enter an index");
		int index = scanner.nextInt();
		System.out.printf("Item %s removed from position %d\n",list.remove(index),index);
	}

}
