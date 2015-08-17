package demos.swing.dialogs.refactored.commands;

import javax.swing.JDialog;
import javax.swing.JFrame;

import demos.swing.dialogs.refactored.MyDialog;

public class CustomDialogCommand extends Command {
	public CustomDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		JDialog customDialog = new MyDialog(getParent());
		customDialog.setVisible(true);
	}

}
