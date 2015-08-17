package demos.swing.layouts.exercise;

import java.awt.Font;

import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Layouts Exercise");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel label = new JLabel("Your Solution Here...");
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,32));
		add(label);
		pack();
	}
}
