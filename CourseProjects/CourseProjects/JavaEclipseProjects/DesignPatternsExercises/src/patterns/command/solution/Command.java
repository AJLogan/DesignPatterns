package patterns.command.solution;

import java.util.List;
import java.util.Scanner;

public abstract class Command {
	public Command(List<String> list, Scanner scanner) {
		this.list = list;
		this.scanner = scanner;
	}
	public abstract boolean execute();
	public abstract void undo();
	public abstract void redo();
	protected List<String> list;
	protected Scanner scanner;
}
