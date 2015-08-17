package demos.swing.flights.solution.v2;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final MainFrame mf = new MainFrame();
		Runnable r = new Runnable() {
			public void run() {
				mf.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
