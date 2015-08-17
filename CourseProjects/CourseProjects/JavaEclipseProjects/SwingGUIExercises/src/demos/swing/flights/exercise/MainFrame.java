package demos.swing.flights.exercise;

import java.awt.Font;

import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Flight Booking Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		controller = new BookingController();
		JLabel label = new JLabel("Your Solution Here...");
		label.setFont(new Font(Font.SANS_SERIF,Font.BOLD,32));
		add(label);
		pack();
	}
	private BookingController controller;
}
