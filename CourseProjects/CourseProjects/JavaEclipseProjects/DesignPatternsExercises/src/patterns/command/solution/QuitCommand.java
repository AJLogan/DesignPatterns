package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public class QuitCommand extends Command {
	public QuitCommand(List<String> list, Scanner scanner) {
		super(list,scanner);
	}
	@Override
	public boolean execute() {
		System.out.println("Thanks for playing!");
		return false;
	}
	@Override
	public void redo() {
		throw new IllegalStateException("Should not be able to request redo of quit");
	}
	@Override
	public void undo() {
		throw new IllegalStateException("Should not be able to request undo of quit");

	}
}
