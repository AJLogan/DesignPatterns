package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputDialogCommand extends Command {
	public InputDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		final String[] drinks = {"Lagavullin","Talisker","Bells"};
		String retval = (String)JOptionPane.showInputDialog(getParent(),"Pick a whisky","An input dialog", JOptionPane.PLAIN_MESSAGE, null, drinks,"Talisker");
		if(retval == null) {
			JOptionPane.showMessageDialog(getParent(),"Obviously you dont like whisky...","A plain message",JOptionPane.PLAIN_MESSAGE);
		} else if(retval.equals("Bells")) {
			JOptionPane.showMessageDialog(getParent(),"You have no taste!","A warning message",JOptionPane.WARNING_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(getParent(),"Good Choice!","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
