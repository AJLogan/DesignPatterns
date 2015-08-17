package demos.swing.layouts.basic;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final MainFrame mf = new MainFrame();
		Runnable r = new Runnable() {
			public void run() {
				mf.setSize(600,500);
				mf.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
