package demos.swing.layouts.solution;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {

	public MainFrame() throws HeadlessException {
		super("Layouts Solution");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(buildTop(),BorderLayout.NORTH);
		add(buildLeft(),BorderLayout.WEST);
		add(buildMiddle(),BorderLayout.CENTER);
	}

	private Component buildTop() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(new JButton("Go!"));
		p.add(new JTextField(20));
		return p;
	}

	private Component buildLeft() {
		Box b = Box.createVerticalBox();
		b.add(new JButton("Button 2"));
		b.add(new JButton("Button 3"));
		b.add(new JButton("Button 4"));
		return b;
	}

	private Component buildMiddle() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBorder(new TitledBorder("Type Here..."));
		JEditorPane editor = new JEditorPane();
		editor.setText("adhsksdhdkassdkhdkasdkshadjkhask");
		System.out.println(editor.getMaximumSize());
		p.add(editor,BorderLayout.CENTER);
		return p;
	}

}
