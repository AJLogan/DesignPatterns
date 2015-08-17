package demos.swing.flying.saucer;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.SwingUtilities;

public class Launcher {
	public static void main(String[] args) throws Exception {
		File f = new File("input/startup.html");
		if(!f.canRead()) {
			System.out.println("Cant read startup page!");
		} else {
			FileInputStream input = new FileInputStream(f);
			final MainFrame frame = new MainFrame("Flying Saucer Demo", input);
			frame.setSize(800,500);
			
			Runnable r = new Runnable() {
				public void run() {
					frame.setVisible(true);
				}
			};
			SwingUtilities.invokeLater(r);
		}
	}
}
