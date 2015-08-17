package demos.swing.dialogs;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Demo of Dialogs");
		createGUI();
		setListeners();
	}
	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		p.setLayout(new GridLayout(8,1));
		addButtons(p);
		
		Container c = getContentPane();
		c.add(new JLabel("The standard dialogs"),BorderLayout.NORTH);
		c.add(p,BorderLayout.CENTER);
		
	}
	private void addButtons(JPanel p) {
		p.add(messageButton);
		p.add(confirmButton);
		p.add(customConfirmButton);
		p.add(inputButton);
		p.add(freeFormInputButton);
		p.add(colorChooserButton);
		p.add(fileChooserButton);
		p.add(customDialogButton);
	}
	private void setListeners() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source == messageButton) {
					demoMessageDialog();
				} else if(source == inputButton) {
					demoInputDialog();
				} else if(source == confirmButton) {
					demoConfirmationDialog();
				} else if(source == customConfirmButton) {
					demoCustomConfirmationDialog();
				} else if(source == freeFormInputButton) {
					demoFreeFormInputDialog();
				} else if(source == colorChooserButton) {
					demoColorChooserDialog();
				} else if(source == fileChooserButton) {
					demoFileChooserDialog();
				} else if(source == customDialogButton) {
					demoCustomDialog();
				}
			}
		};
		messageButton.addActionListener(listener);
		inputButton.addActionListener(listener);
		confirmButton.addActionListener(listener);
		customConfirmButton.addActionListener(listener);
		freeFormInputButton.addActionListener(listener);
		colorChooserButton.addActionListener(listener);
		fileChooserButton.addActionListener(listener);
		customDialogButton.addActionListener(listener);
	}
	protected void demoCustomDialog() {
		JDialog customDialog = new MyDialog(this);
		customDialog.setVisible(true);
	}
	protected void demoFileChooserDialog() {
		final JFileChooser fc = new JFileChooser();
		File f = new File("C:\\");
		if(f.exists()) {
			fc.setCurrentDirectory(f);
		}
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String chosenFile = fc.getSelectedFile().getName();
			JOptionPane.showMessageDialog(this,"You chose " + chosenFile ,"A plain message",JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,"You didnt choose a file!","A warning message",JOptionPane.WARNING_MESSAGE);
		}
	}
	protected void demoColorChooserDialog() {
		Color newColor = JColorChooser.showDialog(this, 
													"Choose A Color",
													colorChooserButton.getBackground());
		if(newColor != null) {
			colorChooserButton.setBackground(newColor);
		}
	}
	private void demoMessageDialog() {
		JOptionPane.showMessageDialog(this,"Welcome to Swing Dialogs!","A normal message",JOptionPane.INFORMATION_MESSAGE);
	}
	private void demoInputDialog() {
		final String[] drinks = {"Lagavullin","Talisker","Bells"};
		String retval = (String)JOptionPane.showInputDialog(MainFrame.this,"Pick a whisky","An input dialog", JOptionPane.PLAIN_MESSAGE, null, drinks,"Talisker");
		if(retval == null) {
			JOptionPane.showMessageDialog(this,"Obviously you dont like whisky...","A plain message",JOptionPane.PLAIN_MESSAGE);
		} else if(retval.equals("Bells")) {
			JOptionPane.showMessageDialog(this,"You have no taste!","A warning message",JOptionPane.WARNING_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this,"Good Choice!","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void demoFreeFormInputDialog() {
		String retval = (String)JOptionPane.showInputDialog(MainFrame.this,"Enter your favorite programming language","An input dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if(retval == null) {
			JOptionPane.showMessageDialog(this,"Not a geek then...","A plain message",JOptionPane.PLAIN_MESSAGE);
		} else if(retval.equalsIgnoreCase("Java")) {
			JOptionPane.showMessageDialog(this,"Good choice!","An information message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this,"How dare you!!!","A normal message",JOptionPane.WARNING_MESSAGE);
		}
	}
	private void demoConfirmationDialog() {
		int retval = JOptionPane.showConfirmDialog(this,"Do you really want to take the red pill?","A confirmation request",JOptionPane.YES_NO_OPTION);
		if(JOptionPane.YES_OPTION == retval) {
			JOptionPane.showMessageDialog(this,"Follow the white rabbit... ","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this,"Quitter!","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void demoCustomConfirmationDialog() {
		int retval = JOptionPane.showOptionDialog(this,
													"What was Javas original name?",
													"A confirmation request",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													null,
													new String[] {"Oak","Elm"},
													"Oak");
		if(JOptionPane.YES_OPTION == retval) {
			JOptionPane.showMessageDialog(this,"Yes indeed - geek kudos!","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this,"Sorry - wrong tree...","A normal message",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private JButton inputButton = new JButton("Asking for Input");
	private JButton confirmButton = new JButton("Requesting Confirmation");
	private JButton messageButton = new JButton("Standard Message");
	private JButton customConfirmButton = new JButton("Customized Confirmation");
	private JButton freeFormInputButton = new JButton("Asking for Input (Free Form)");
	private JButton colorChooserButton = new JButton("Choosing a Color");
	private JButton fileChooserButton = new JButton("Choosing a File");
	private JButton customDialogButton = new JButton("Custom Dialog");
}

