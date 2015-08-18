package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class GetCommand extends Command  {

	public GetCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("Enter an index");
		int index = scanner.nextInt();
		System.out.printf("Item at %d is %s\n",index,list.get(index));
	}

}
