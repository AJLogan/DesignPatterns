package demos.tdd.fest.dialogs;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class DialogsDemo extends JFrame {
	public DialogsDemo() {
		createGUI();
		setListeners();
		pack();
	}
	private void createGUI() {
		inputButton.setName("input");
		confirmationButton.setName("confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//use BoxLayout for the buttons
		Box b = Box.createHorizontalBox();
		addButtons(b);
		//need to use a JPanel to make a border
		JPanel p = new JPanel();
		p.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		p.add(b);
		//add everything to the frame
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,1));
		c.add(new JLabel("The standard dialogs"));
		c.add(p);
	}
	private void addButtons(Box b) {
		b.add(inputButton);
		b.add(confirmationButton);
	}
	private void setListeners() {
		inputButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											final String[] drinks = {"Lagavullin","Talisker","Bells"};
											String retval = (String)JOptionPane.showInputDialog(DialogsDemo.this,"Pick a whisky","An input dialog", JOptionPane.PLAIN_MESSAGE, null, drinks,"Talisker");
											if(retval.equals("Bells")) {
												JOptionPane.showMessageDialog(DialogsDemo.this,"You have no taste!","A warning message",JOptionPane.WARNING_MESSAGE);
											}
											else {
												JOptionPane.showMessageDialog(DialogsDemo.this,"Fair enough","A normal message",JOptionPane.INFORMATION_MESSAGE);
											}
										}
									});
		confirmationButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											int retval = JOptionPane.showConfirmDialog(DialogsDemo.this,"Do you really want to take the red pill?","A confirmation request",JOptionPane.YES_NO_OPTION);
											if(JOptionPane.YES_OPTION == retval) {
												JOptionPane.showMessageDialog(DialogsDemo.this,"Follow the white rabbit...","An error message",JOptionPane.ERROR_MESSAGE);
											}
											else {
												JOptionPane.showMessageDialog(DialogsDemo.this,"Quitter!","A normal message",JOptionPane.INFORMATION_MESSAGE);
											}
										}
									});
	}
	

	private JButton inputButton = new JButton("input");
	private JButton confirmationButton = new JButton("confirmation");
}
