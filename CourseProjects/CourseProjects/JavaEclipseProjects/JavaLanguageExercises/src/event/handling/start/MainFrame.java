package event.handling.start;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics param) {
			super.paintComponent(param);
			
		}	
	}
	public MainFrame() {
		super("Event Handling Exercise");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawingPanel = new MyPanel();
		topLabel = new JLabel("Messages Here...");
		topLabel.setFont(new Font("", Font.BOLD,16));
		add(topLabel,BorderLayout.NORTH);
		add(drawingPanel,BorderLayout.CENTER);
	}
	private JLabel topLabel;
	private JPanel drawingPanel;
}
