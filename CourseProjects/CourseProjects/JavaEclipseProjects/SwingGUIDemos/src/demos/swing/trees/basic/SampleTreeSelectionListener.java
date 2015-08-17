package demos.swing.trees.basic;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class SampleTreeSelectionListener implements TreeSelectionListener {
	public SampleTreeSelectionListener(JTextField box) {
		super();
		textBox = box;
	}
	public void valueChanged(TreeSelectionEvent event) {
		TreePath path = event.getNewLeadSelectionPath();
		textBox.setText(path.toString());
	}
	private JTextField textBox;
}
