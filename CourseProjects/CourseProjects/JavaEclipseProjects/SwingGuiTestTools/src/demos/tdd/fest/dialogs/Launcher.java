package demos.tdd.fest.dialogs;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) {
		final DialogsDemo demo = new DialogsDemo();
		Runnable r = new Runnable() {
			public void run() {
				demo.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
