package demos.swing.flights.solution.v2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class FlightsListModel implements ListModel {
	public FlightsListModel(List<String> items) {
		super();
		this.items = new ArrayList<String>();
		this.items.addAll(items);
		listeners = new ArrayList<ListDataListener>();
	}
	public void addListDataListener(ListDataListener param) {
		listeners.add(param);
	}
	public Object getElementAt(int index) {
		return items.get(index);
	}
	public int getSize() {
		return items.size();
	}
	public void removeListDataListener(ListDataListener param) {
		listeners.remove(param);
	}
	private List<String> items;
	private List<ListDataListener> listeners;
}
