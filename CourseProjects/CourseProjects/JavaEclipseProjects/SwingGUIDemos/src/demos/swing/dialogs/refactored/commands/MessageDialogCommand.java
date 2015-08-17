package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MessageDialogCommand extends Command {
	public MessageDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		JOptionPane.showMessageDialog(getParent(),"Welcome to Swing Dialogs!","A normal message",JOptionPane.INFORMATION_MESSAGE);
	}
}
