package demos.tdd.fest.basic;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final SimpleGui gui = new SimpleGui("Simple Swing App");
		Runnable r = new Runnable() {
			public void run() {
				gui.pack();
				gui.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
