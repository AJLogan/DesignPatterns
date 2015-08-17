package demos.tdd.fest.basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleGui extends JFrame {
	public SimpleGui(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(10);
		tf.setName("myTextField");
		b = new JButton("Push Me");
		b.setName("myButton");

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
	private JTextField tf;
	private JButton b;
}

