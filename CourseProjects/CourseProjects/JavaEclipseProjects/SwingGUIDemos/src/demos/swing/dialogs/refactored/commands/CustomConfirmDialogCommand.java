package demos.swing.dialogs.refactored.commands;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CustomConfirmDialogCommand extends Command {
	public CustomConfirmDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		int retval = JOptionPane.showOptionDialog(getParent(),
												  "What was Javas original name?", 
												  "A confirmation request",
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null,
												  new String[] { "Oak", "Elm" }, "Oak");
		if (JOptionPane.YES_OPTION == retval) {
			JOptionPane.showMessageDialog(getParent(),
										  "Yes indeed - geek kudos!", 
										  "A normal message",
										  JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getParent(), 
										  "Sorry - wrong tree...",
										  "A normal message", 
										  JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
