package demos.swing.basic;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleGui5 extends JFrame {

	public SimpleGui5(String name) {
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
		final SimpleGui5 sg = new SimpleGui5("Simple Swing App");
		Runnable r = new Runnable() {
			public void run() {
				sg.pack();
				sg.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);

	}
	private JTextField tf;
	private JButton b;
}
