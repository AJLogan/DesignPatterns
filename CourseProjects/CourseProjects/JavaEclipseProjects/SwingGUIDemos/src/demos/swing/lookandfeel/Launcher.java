package demos.swing.lookandfeel;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import demos.swing.layouts.group.MainFrame;

public class Launcher {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
		
		Runnable r = new Runnable() {
			public void run() {
				MainFrame mf = new MainFrame();
				mf.pack();
				mf.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
