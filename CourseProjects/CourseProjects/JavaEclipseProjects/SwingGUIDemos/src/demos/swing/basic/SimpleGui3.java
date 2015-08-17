package demos.swing.basic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui3 extends JFrame {

	public SimpleGui3(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(10);
		b = new JButton("Push Me");

		ActionListener listener = new ButtonListener();
		b.addActionListener(listener);

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b);
		cp.add(tf);
	}
	public static void main(String[] args) {
		SimpleGui3 sg = new SimpleGui3("Simple Swing App");
		sg.pack();
		sg.setVisible(true);
	}
	//inner class
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    tf.setText("Button One Pushed");
		}
	}
	private JTextField tf;
	private JButton b;
}








