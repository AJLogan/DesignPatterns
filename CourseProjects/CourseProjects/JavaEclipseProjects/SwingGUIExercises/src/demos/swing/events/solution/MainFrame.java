package demos.swing.events.solution;

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
			if(chosenX > 0 || chosenY > 0) {
				Graphics2D g = (Graphics2D)param;
				g.drawOval(chosenX,chosenY, 20, 20);
				g.setColor(Color.BLUE);
				g.fillOval(chosenX,chosenY, 20, 20);
				g.setColor(Color.BLACK);
			}
		}	
	}
	public class MyMouseListener implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			topLabel.setText("Mouse clicked in panel");
			chosenX = e.getX();
			chosenY = e.getY();
			repaint();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			topLabel.setText("Mouse entered panel");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			topLabel.setText("Mouse exited panel");
		}
		@Override
		public void mousePressed(MouseEvent e) {
			topLabel.setText("Mouse pressed in panel");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			topLabel.setText("Mouse released in panel");
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			topLabel.setText("Mouse dragged...");
			chosenX = e.getX();
			chosenY = e.getY();
			repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}
	public MainFrame() {
		super("Event Handling Solution");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,250);
		drawingPanel = new MyPanel();
		MyMouseListener listener = new MyMouseListener();
		drawingPanel.addMouseListener(listener);
		drawingPanel.addMouseMotionListener(listener);
		topLabel = new JLabel("Messages Here...");
		topLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		add(topLabel,BorderLayout.NORTH);
		add(drawingPanel,BorderLayout.CENTER);
	}
	private JLabel topLabel;
	private JPanel drawingPanel;
	private int chosenX;
	private int chosenY;
}
