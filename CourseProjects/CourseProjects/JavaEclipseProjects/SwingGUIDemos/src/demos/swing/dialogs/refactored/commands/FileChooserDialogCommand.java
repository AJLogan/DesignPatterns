package demos.swing.dialogs.refactored.commands;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileChooserDialogCommand extends Command {
	public FileChooserDialogCommand(JFrame parent) {
		super(parent);
	}
	@Override
	public void execute() {
		final JFileChooser fc = new JFileChooser();
		File f = new File("C:\\");
		if(f.exists()) {
			fc.setCurrentDirectory(f);
		}
		int returnVal = fc.showOpenDialog(getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String chosenFile = fc.getSelectedFile().getName();
			JOptionPane.showMessageDialog(getParent(),"You chose " + chosenFile ,"A plain message",JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getParent(),"You didnt choose a file!","A warning message",JOptionPane.WARNING_MESSAGE);
		}
	}
}
