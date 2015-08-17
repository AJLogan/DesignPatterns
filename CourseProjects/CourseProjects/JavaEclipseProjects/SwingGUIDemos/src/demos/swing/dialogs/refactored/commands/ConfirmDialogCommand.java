package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmDialogCommand extends Command {
	public ConfirmDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		int retval = JOptionPane.showConfirmDialog(getParent(),"Do you really want to take the red pill?","A confirmation request",JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == retval) {
			JOptionPane.showMessageDialog(getParent(),"Follow the white rabbit... ","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(getParent(),"Quitter!","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
