package demos.swing.dialogs.refactored.commands;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooserDialogCommand extends Command {
	public ColorChooserDialogCommand(JFrame parent, JButton button) {
		super(parent);
		this.button = button;
	}
	@Override
	public void execute() {
		Color newColor = JColorChooser.showDialog(getParent(), 
												  "Choose A Color",
												  button.getBackground());
		if(newColor != null) {
			button.setBackground(newColor);
		}
	}
	private JButton button;
}
