package patterns.command.start;

import java.util.List;
import java.util.Scanner;

public class UndoCommand extends Command  {

	public UndoCommand(Scanner scanner, List<String> list) {
		super(scanner, list);
	}

	@Override
	public void execute() {
		System.out.println("NOT IMPLEMENTED YET!");
	}

}
