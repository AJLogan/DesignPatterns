package demos.swing.events.keystrokes;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		super("Demo of KeyStrokes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField = new JTextField(20);
		add(textField,BorderLayout.CENTER);
		createAndRegisterKeystrokes();
	}
	private void createAndRegisterKeystrokes() {
		KeyStroke stroke1 = KeyStroke.getKeyStroke('A');
		registerKeyStroke(stroke1,action1,"string1");
		KeyStroke stroke2 = KeyStroke.getKeyStroke('1',InputEvent.CTRL_DOWN_MASK);
		registerKeyStroke(stroke2,action2,"string2");
		KeyStroke stroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, true);
		registerKeyStroke(stroke3,action3,"string3");
	}
	private void registerKeyStroke(KeyStroke stroke, Action action, String string) {
		textField.getInputMap().put(stroke,string);
		textField.getActionMap().put(string, action);
	}
	private Action action1 = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("First action called");
			textField.setText("XXX");
		}
	};
	private Action action2 = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Second action called");
			textField.setText("YYY");
		}
	};
	private Action action3 = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Third action called");
			textField.setText("ZZZ");
		}
	};
	private JTextField textField;
}
