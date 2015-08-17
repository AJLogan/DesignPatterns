package demos.swing.dialogs.refactored;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyDialog extends JDialog {
	public MyDialog(JFrame parent) {
		super(parent,"A Custom Dialog", true);
		dismissButton = new JButton("OK");
		dismissButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		getContentPane().add(new JLabel("A Custom Dialog"),BorderLayout.NORTH);
		getContentPane().add(dismissButton,BorderLayout.CENTER);
		pack();
	}
	private JButton dismissButton;
}
