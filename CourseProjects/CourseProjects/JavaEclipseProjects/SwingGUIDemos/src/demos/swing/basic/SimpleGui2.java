package demos.swing.basic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui2 extends JFrame implements ActionListener {

	public SimpleGui2(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(10);
		b = new JButton("Push Me");

		b.addActionListener(this);

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b);
		cp.add(tf);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Pushed");
		tf.setText("Button Pushed");
	}
	public static void main(String[] args) {
		SimpleGui2 sg = new SimpleGui2("Simple Swing App");
		sg.pack();
		sg.setVisible(true);
		try {
		    Thread.sleep(3000);
		} catch(Exception ex) {System.out.println(ex);}
		ActionEvent ae = new ActionEvent(new Object(),101,"XXX");
		sg.actionPerformed(ae);
	}

	private JTextField tf;
	private JButton b;
}






