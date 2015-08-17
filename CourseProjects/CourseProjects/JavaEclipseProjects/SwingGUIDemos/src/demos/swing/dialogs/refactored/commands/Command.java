package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;

public abstract class Command {
	public Command(JFrame parent) {
		super();
		this.parent = parent;
	}
	JFrame getParent() {
		return parent;
	}
	public abstract void execute();
	private JFrame parent;
}
