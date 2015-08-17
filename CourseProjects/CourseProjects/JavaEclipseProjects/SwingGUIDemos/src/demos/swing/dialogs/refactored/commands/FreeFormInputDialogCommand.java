package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FreeFormInputDialogCommand extends Command {
	public FreeFormInputDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		String retval = (String)JOptionPane.showInputDialog(getParent(),"Enter your favorite programming language","An input dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if(retval == null) {
			JOptionPane.showMessageDialog(getParent(),"Not a geek then...","A plain message",JOptionPane.PLAIN_MESSAGE);
		} else if(retval.equalsIgnoreCase("Java")) {
			JOptionPane.showMessageDialog(getParent(),"Good choice!","An information message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(getParent(),"How dare you!!!","A normal message",JOptionPane.WARNING_MESSAGE);
		}
	}

}
