package demos.swing.tables.advanced;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
	public EmployeeTableModel() {
		super();
		employees = new ArrayList<Employee>();
		setData();
	}
	private void setData() {
		employees.add(new Employee("Dave", "IT", 21, 30500.0, false));
		employees.add(new Employee("Jane", "HR", 22, 31000.0, false));
		employees.add(new Employee("Fred", "IT", 23, 31500.0, false));
		employees.add(new Employee("Mary", "HR", 24, 32000.0, false));
		employees.add(new Employee("Peter", "IT", 25, 32500.0, false));
		employees.add(new Employee("Lucy", "HR", 26, 33000.0, false));
		employees.add(new Employee("Simon", "IT", 27, 33500.0, false));
		employees.add(new Employee("Hazel", "HR", 28, 34000.0, false));
	}
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	@Override
	public int getColumnCount() {
		return columns.length;
	}
	@Override
	public int getRowCount() {
		return employees.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee emp = employees.get(rowIndex);
		Object value = null;
		switch(columnIndex) {
		case 0:
			value = emp.getName();
			break;
		case 1:
			value = emp.getDept();
			break;
		case 2:
			value = emp.getAge();
			break;
		case 3:
			value = emp.getSalary();
			break;
		case 4:
			value = new Boolean(emp.isOnLeave());
			break;
		}
		return value;
	}
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Employee emp = employees.get(rowIndex);
		switch(columnIndex) {
		case 0:
			emp.setName((String)value);
			break;
		case 1:
			emp.setDept((String)value);
			break;
		case 2:
			emp.setAge((Integer)value);
			break;
		case 3:
			emp.setSalary(Double.parseDouble((String)value));
			break;
		case 4:
			emp.setOnLeave((Boolean)value);
			break;
		}
	}
	@Override
	public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	public void addEmployee(Employee emp) {
		int index = employees.size();
		employees.add(emp);
		fireTableRowsInserted(index, index);
	}
	private String [] columns = {"Name", "Department", "Age", "Salary", "On Leave"};
	private List<Employee> employees;
}
