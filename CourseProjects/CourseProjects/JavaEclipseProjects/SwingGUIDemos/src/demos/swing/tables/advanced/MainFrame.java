package demos.swing.tables.advanced;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.TableModel;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Event Handling Exercise");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		model = new EmployeeTableModel();
		table = new EmployeesTable(model);
		panel = new AddEmployeePanel(model);
		Box b = Box.createVerticalBox();
		b.add(panel);
		b.add(new JScrollPane(table));
		add(b,BorderLayout.CENTER);
	}
	private JTable table;
	private JPanel panel;
	private TableModel model;
	
}
