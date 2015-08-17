package demos.swing.tables;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class SampleTableModel extends AbstractTableModel {
	public SampleTableModel() {
		columnNames = new String[]{"Title A","Title B","Title C"};
		list = new ArrayList<ArrayList<String>>();
		addFirstRow();
		addSecondRow();
		addThirdRow();
	}
	private void addFirstRow() {
		ArrayList<String> subList = new ArrayList<String>();
		subList.add("abc");
		subList.add("def");
		subList.add("ghi");
		subList.add("jkl");
		subList.add("mno");
		list.add(subList);
	}
	private void addSecondRow() {
		ArrayList<String> subList = new ArrayList<String>();
		subList.add("cab");
		subList.add("fde");
		subList.add("igh");
		subList.add("ljk");
		subList.add("omn");
		list.add(subList);
	}
	private void addThirdRow() {
		ArrayList<String> subList = new ArrayList<String>();
		subList.add("bca");
		subList.add("efd");
		subList.add("hig");
		subList.add("klj");
		subList.add("nom");
		list.add(subList);
	}
	public int getRowCount() {
		return list.size();
	}
	public int getColumnCount() {
		return columnNames.length;
	}
	public String getColumnName(int column) {
		return columnNames[column];
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return list.get(rowIndex).get(columnIndex);
	}
	private ArrayList<ArrayList<String>> list;
	private String [] columnNames;
}
