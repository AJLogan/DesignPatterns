package demos.swing.tables.advanced;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class EmployeesTable extends JTable {
	public EmployeesTable(TableModel model) {
		super(model);
		setCellEditors();
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}
	private void setCellEditors() {
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("IT");
		comboBox.addItem("HR");
		comboBox.addItem("Sales");
		comboBox.addItem("Billing");
		TableColumn secondColumn = getColumnModel().getColumn(1);
		secondColumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn firstColumn = getColumnModel().getColumn(3);
		firstColumn.setCellEditor(new DefaultCellEditor(new JFormattedTextField(new Double(0))));
	}
}
