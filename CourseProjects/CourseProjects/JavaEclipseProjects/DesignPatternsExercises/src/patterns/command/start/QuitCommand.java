package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class QuitCommand extends Command {

	public QuitCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("Thanks for playing!");
	}

}
