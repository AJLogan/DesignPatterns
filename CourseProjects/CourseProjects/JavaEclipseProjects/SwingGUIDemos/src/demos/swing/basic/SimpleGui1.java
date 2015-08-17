package demos.swing.basic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui1 extends JFrame {

	public SimpleGui1(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(10);
		b = new JButton("Push Me");

		b.addActionListener(new SimpleListener(this));

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b);
		cp.add(tf);
	}
	public static void main(String[] args) {
		SimpleGui1 sg = new SimpleGui1("Simple Swing App");
		sg.pack();
		sg.setVisible(true);
	}

	JTextField tf;
	private JButton b;
}

class SimpleListener implements ActionListener {

	public SimpleListener(SimpleGui1 gui) {
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Pushed");
		gui.tf.setText("Button Pushed");
	}
	private SimpleGui1 gui;
}
