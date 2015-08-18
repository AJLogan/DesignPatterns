package exercises.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyGui extends JFrame {
	public MyGui() {
		super("My Swing GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		button = new JButton("Push Me");
		textField = new JTextField(10);
		
		setLayout(new FlowLayout());
		add(button);
		add(textField);
	}
	
	private JButton button;
	private JTextField textField;
}
