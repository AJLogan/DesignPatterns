package demos.swing.basic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui4 extends JFrame {

	public SimpleGui4(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(10);
		b = new JButton("Push Me");

		//anonymous inner class
		b.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent e) {
									System.out.println("Button Pushed");
									tf.setText("Button Pushed");
								}
							});

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b);
		cp.add(tf);
	}
	public static void main(String[] args) {
		SimpleGui4 sg = new SimpleGui4("Simple Swing App");
		sg.pack();
		sg.setVisible(true);
	}
	private JTextField tf;
	private JButton b;
}

