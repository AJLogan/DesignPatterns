package demos.swing.splash.screens;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Event Handling Exercise");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		topLabel = new JLabel("My GUI is running...");
		topLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,32));
		add(topLabel,BorderLayout.CENTER);
	}
	private JLabel topLabel;
}
