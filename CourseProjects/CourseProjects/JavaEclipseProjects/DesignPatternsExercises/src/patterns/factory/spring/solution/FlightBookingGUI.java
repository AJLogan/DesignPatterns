package patterns.factory.spring.solution;

import static javax.swing.JOptionPane.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.List;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("serial")
public class FlightBookingGUI extends JFrame implements ActionListener {
	public FlightBookingGUI(FlightsTableModel resultsTableModel, 
							FlightsTableModel offersTableModel, 
							ListModel airportsModel, 
							String [] months, 
							Integer [] days, 
							String text1, String text2, String text3, 
							String text4, String text5, String text6) {
		super("Flight Booking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		originLabel = buildBlueLabel(text1);
		destinationLabel = buildBlueLabel(text2);
		monthLabel = buildBlueLabel(text3);
		dayLabel = buildBlueLabel(text4);

		searchButton = new JButton(text5);
		bookingButton = new JButton(text6);

		//Setup the tables and their models
		this.resultsTableModel = resultsTableModel;
		searchResultsTable = new JTable(resultsTableModel);
		this.offersTableModel = offersTableModel;
		specialOffersTable = new JTable(offersTableModel);

		originSelection = new JList(airportsModel);
		destinationSelection = new JList(airportsModel);

		monthSelection = new JComboBox(months);
		daySelection = new JComboBox(days);

		finishSetup();
	}
	private JLabel buildBlueLabel(String msg) {
		JLabel tmp = new JLabel(msg);
		tmp.setForeground(Color.BLUE);
		return tmp;
	}
	private void finishSetup() {
		createLayout();
		addEventHandling();
		pack();
	}
	private void addEventHandling() {
		searchButton.addActionListener(this);
		bookingButton.addActionListener(this);
	}
	private void createLayout() {
		flightSearchPanel = createFlightSelectionPanel();

		Box tablesBox = createBoxForTables();

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setAutoCreateGaps(true);
		getContentPane().setLayout(layout);

		ParallelGroup g1 = layout.createParallelGroup();
		g1.addComponent(flightSearchPanel);
		g1.addComponent(searchButton);
		g1.addComponent(tablesBox);
		g1.addComponent(bookingButton);
		layout.setHorizontalGroup(g1);

		SequentialGroup g2 = layout.createSequentialGroup();
		g2.addComponent(flightSearchPanel);
		g2.addComponent(searchButton);
		g2.addComponent(tablesBox);
		g2.addComponent(bookingButton);
		layout.setVerticalGroup(g2);
	}
	private Box createBoxForTables() {
		Box box = Box.createVerticalBox();
		JScrollPane tmp;
		specialOffersTable.setPreferredScrollableViewportSize(new Dimension(450, 100));
		searchResultsTable.setPreferredScrollableViewportSize(new Dimension(450, 200));
		tmp = new JScrollPane(specialOffersTable);
		tmp.setBorder(new TitledBorder("Current Special Offers"));
		box.add(tmp);
		tmp = new JScrollPane(searchResultsTable);
		tmp.setBorder(new TitledBorder("Available Flights"));
		box.add(tmp);
		return box;
	}
	private JPanel createFlightSelectionPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Select flight details below:"));

		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		panel.setLayout(layout);

		SequentialGroup g1 = layout.createSequentialGroup();
		ParallelGroup g2 = layout.createParallelGroup();
		g2.addComponent(originLabel);
		g2.addComponent(originSelection);
		SequentialGroup g3 = layout.createSequentialGroup();
		g3.addComponent(monthLabel);
		g3.addComponent(monthSelection);
		g2.addGroup(g3);

		ParallelGroup g4 = layout.createParallelGroup();
		g4.addComponent(destinationLabel);
		g4.addComponent(destinationSelection);
		SequentialGroup g5 = layout.createSequentialGroup();
		g5.addComponent(dayLabel);
		g5.addComponent(daySelection);
		g4.addGroup(g5);

		g1.addGroup(g2);
		g1.addGroup(g4);
		layout.setHorizontalGroup(g1);

		SequentialGroup g6 = layout.createSequentialGroup();

		ParallelGroup g7 = layout.createParallelGroup();
		g7.addComponent(originLabel);
		g7.addComponent(destinationLabel);

		ParallelGroup g8 = layout.createParallelGroup();
		g8.addComponent(originSelection);
		g8.addComponent(destinationSelection);

		ParallelGroup g9 = layout.createParallelGroup(Alignment.BASELINE);
		g9.addComponent(monthLabel);
		g9.addComponent(monthSelection);
		g9.addComponent(dayLabel);
		g9.addComponent(daySelection);

		g6.addGroup(g7);
		g6.addGroup(g8);
		g6.addGroup(g9);

		layout.setVerticalGroup(g6);

		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bookingButton) {
			makeBooking();
		} else if (e.getSource() == searchButton) {
			runSearch();
		}
	}
	private void runSearch() {
		if (originSelection.getSelectedIndex() >= 0 && destinationSelection.getSelectedIndex() >= 0) {
			String outbound = (String) originSelection.getSelectedValue();
			String inbound = (String) destinationSelection.getSelectedValue();
			Date date = buildDateFromGuiInputs();

			List<Flight> results = controller.findAvailableFlights(outbound, inbound, date);
			resultsTableModel.addFlights(results);
		} else {
			showMessageDialog(this, "Please choose airports!", "Error", ERROR_MESSAGE);
		}
	}
	private void makeBooking() {
		int rowSelected = searchResultsTable.getSelectedRow();
		if (rowSelected >= 0) {
			Flight flight = resultsTableModel.getFlight(rowSelected);
			boolean result = controller.bookFlight(flight);
			if (result) {
				showMessageDialog(this, "Flight Booked!", "Result", INFORMATION_MESSAGE);
			} else {
				showMessageDialog(this, "Booking Failed!", "Result", INFORMATION_MESSAGE);
			}
		} else {
			showMessageDialog(this, "Please choose a flight!", "Error", ERROR_MESSAGE);
		}
	}
	private Date buildDateFromGuiInputs() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		String dateAsString = formatDateString();
		Date date = null;
		try {
			date = df.parse(dateAsString);
		} catch (ParseException ex) {
			String msg = "Cannot make sense of '" + dateAsString + "'";
			JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
		}
		return date;
	}
	private String formatDateString() {
		StringBuffer sb = new StringBuffer();
		sb.append(monthSelection.getSelectedItem().toString());
		sb.append(" ");
		sb.append(daySelection.getSelectedItem().toString());
		sb.append(", 2008");
		return sb.toString();
	}
	public BookingController getController() {
		return controller;
	}
	public void setController(BookingController controller) {
		this.controller = controller;
	}
	// Controller class
	private BookingController controller;
	// Swing widgets
	private FlightsTableModel resultsTableModel;
	@SuppressWarnings("unused")
	private FlightsTableModel offersTableModel;
	private JTable searchResultsTable;
	private JTable specialOffersTable;
	private JPanel flightSearchPanel;
	private JList originSelection;
	private JList destinationSelection;
	private JComboBox monthSelection;
	private JComboBox daySelection;
	private JLabel originLabel;
	private JLabel destinationLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JButton searchButton;
	private JButton bookingButton;
}
