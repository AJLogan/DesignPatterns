package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class AddCommand extends Command{

	public AddCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("Enter a string to add");
		String item = scanner.nextLine();
		list.add(item);
	}

}
