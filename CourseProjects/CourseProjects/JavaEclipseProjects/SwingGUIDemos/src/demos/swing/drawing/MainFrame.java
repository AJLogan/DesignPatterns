package demos.swing.drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class MainFrame extends JFrame {
	private static final int INNER_CIRCLE_HEIGHT = 100;
	private static final int INNER_CIRCLE_WIDTH = 100;
	private static final int OUTER_CIRCLE_HEIGHT = 200;
	private static final int OUTER_CIRCLE_WIDTH = 200;
	
	public MainFrame() {
		super("Demo of Graphics");
		setSize(400,400);
		add(panel,BorderLayout.CENTER);
	}
	private JPanel panel = new JPanel() {
		@Override
		public void paintComponent(Graphics param) {
			super.paintComponent(param);
			Graphics2D g = (Graphics2D)param;
			int width = getWidth();
			int height = getHeight();
			
			g.drawOval((width/2) - (OUTER_CIRCLE_WIDTH/2),
					   (height/2) - (OUTER_CIRCLE_HEIGHT/2),
					   OUTER_CIRCLE_WIDTH,
					   OUTER_CIRCLE_HEIGHT);
			g.setColor(Color.YELLOW);
			g.fillOval((width/2) - (OUTER_CIRCLE_WIDTH/2),
					   (height/2) - (OUTER_CIRCLE_HEIGHT/2),
					   OUTER_CIRCLE_WIDTH,
					   OUTER_CIRCLE_HEIGHT);
			g.setColor(Color.BLACK);
			g.drawOval((width/2) - (INNER_CIRCLE_WIDTH/2),
					   (height/2) - (INNER_CIRCLE_HEIGHT/2),
					   INNER_CIRCLE_WIDTH,
					   INNER_CIRCLE_HEIGHT);
			g.setColor(Color.BLUE);
			g.fillOval((width/2) - (INNER_CIRCLE_WIDTH/2),
					   (height/2) - (INNER_CIRCLE_HEIGHT/2),
					   INNER_CIRCLE_WIDTH,
					   INNER_CIRCLE_HEIGHT);
			g.setColor(Color.BLACK);
			g.drawLine(0, 0, width, height);
			g.drawLine(width, 0, 0, height);
		}
	};
}
