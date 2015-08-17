package demos.swing.events.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

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
		topLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		add(topLabel,BorderLayout.NORTH);
		add(drawingPanel,BorderLayout.CENTER);
	}
	private JLabel topLabel;
	private JPanel drawingPanel;
}
