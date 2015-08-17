package demos.swing.layouts.group;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final MainFrame mf = new MainFrame();
		Runnable r = new Runnable() {
			public void run() {
				mf.pack();
				mf.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
