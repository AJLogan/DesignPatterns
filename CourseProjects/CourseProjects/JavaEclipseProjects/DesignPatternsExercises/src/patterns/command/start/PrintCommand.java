package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class PrintCommand extends Command  {

	public PrintCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("Contents of list are: ");
		for(String str : list) {
			System.out.println("\t" + str); 
		}
	}

}
