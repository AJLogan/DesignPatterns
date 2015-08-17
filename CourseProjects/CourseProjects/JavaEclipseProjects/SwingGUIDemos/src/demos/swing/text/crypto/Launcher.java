package demos.swing.text.crypto;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) throws Exception {
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
