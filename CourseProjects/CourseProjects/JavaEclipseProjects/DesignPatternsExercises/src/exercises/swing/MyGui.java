package exercises.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;




public class MyGui extends JFrame {
	private class MyListner implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.out.println("Button Pushed");
			textField.setText("ButtonPushed");
		}
	}
	
	public MyGui() {
		super("My Swing GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		button = new JButton("Push Me");
		button.addActionListener(new MyListner());
		textField = new JTextField(10);
		
		setLayout(new FlowLayout());
		add(button);
		add(textField);
	}
	
	private JButton button;
	private JTextField textField;
}
