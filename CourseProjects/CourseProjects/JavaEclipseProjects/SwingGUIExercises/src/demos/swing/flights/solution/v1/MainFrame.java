package demos.swing.flights.solution.v1;

import static javax.swing.JOptionPane.*;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Locale;

public class MainFrame extends JFrame implements ActionListener {
	public MainFrame() {
		super("Flight Booking Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		controller = new BookingController();

		originLabel = buildBlueLabel("Origin Airport");
		destinationLabel = buildBlueLabel("Destination Airport");
		monthLabel = buildBlueLabel("Month of Travel");
		dayLabel = buildBlueLabel("Day of Travel");

		searchButton = new JButton("Search For Flights");
		bookingButton = new JButton("Book Flight");

		//Setup the tables and their models
		String [] columns = {"origin","destination","date","time"};
		String [][] data = {
								{"ab","cd","ef","gh"},
								{"ij","kl","mn","op"},
								{"qr","st","uv","wx"},
								{"yz","ab","cd","ef"}
							};
		searchResultsTable = new JTable(data,columns);

		// Setup the list boxes for origin and destination airports
		List<String> list1 = new ArrayList<String>();
		list1.add("Heathrow");
		list1.add("Belfast International");
		list1.add("Belfast City");
		list1.add("Dublin");
		list1.add("Birmingham");
		list1.add("Luton");
		originSelection = new JList(list1.toArray());
		destinationSelection = new JList(list1.toArray());

		// Setup the combo boxes for days and months
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		Integer[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
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
		searchResultsTable.setPreferredScrollableViewportSize(new Dimension(450, 200));
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

		ParallelGroup g9 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
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

	public void setBookingController(BookingController controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bookingButton) {
			makeBooking();
		} else if (e.getSource() == searchButton) {
			runSearch();
		}
	}

	private void runSearch() {
		showMessageDialog(this, "TODO!", "Error", ERROR_MESSAGE);
	}

	private void makeBooking() {
		showMessageDialog(this, "TODO!", "Error", ERROR_MESSAGE);
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

	// Controller class
	private BookingController controller;
	// Swing widgets
	private JTable searchResultsTable;
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
