package exercises.tdd.fest.flights.finish;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Launcher {
    public static void main(String[] args) throws Exception {
    	final JFrame gui = FlightBookingGUI.createGUI();
    	Runnable r = new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
    }
}
