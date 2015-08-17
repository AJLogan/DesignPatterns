package demos.swing.splash.screens;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.SwingUtilities;

//run via build file to see splash screen
public class Launcher {
	private static final int HEIGHT = 250;
	private static final int WIDTH = 400;

	public static void main(String[] args) {
		final MainFrame mf = new MainFrame();
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				mf.setSize(WIDTH,HEIGHT);
				mf.setLocation(findStartingPoint());
		        mf.toFront();
				mf.setVisible(true);
			}

			private Point findStartingPoint() {
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		        Point center = ge.getCenterPoint();
		        Point startPoint = new Point(center.x - WIDTH, center.y - HEIGHT);
				return startPoint;
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
