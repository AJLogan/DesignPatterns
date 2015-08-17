package demos.swing.events.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class MyAction extends AbstractAction {
	public MyAction() {
		setEnabled(true);
		putValue(Action.NAME,"MyName");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("The button '" + e.getActionCommand() + "' was pushed...");
	}
	public void makeChanges() {
		boolean enabled = isEnabled();
		setEnabled(!enabled);
		
		String oldName = (String)getValue(Action.NAME);
		String newName = oldName + "X";
		
		putValue(Action.NAME,newName);
		firePropertyChange(Action.NAME, oldName, newName);
	}
}
