package patterns.command.start;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class Command {
	
	protected Scanner scanner = new Scanner(System.in);
	protected List<String> list = new LinkedList<String>();
	
	public Command(Scanner scanner, List<String> list){
		super();
		this.scanner = scanner;
		this.list = list;
	}
	
	public abstract void execute();

}
