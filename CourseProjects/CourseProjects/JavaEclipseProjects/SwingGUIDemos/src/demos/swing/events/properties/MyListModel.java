package demos.swing.events.properties;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

class MyListModel extends AbstractListModel<String> {
	public MyListModel() {
		super();
		this.list = new ArrayList<String>();
	}
	@Override
	public String getElementAt(int index) {
		return list.get(index);
	}
	@Override
	public int getSize() {
		return list.size();
	}
	public void add(String message) {
		list.add(message);
		int index = list.size() - 1;
		this.fireContentsChanged(this, index, index);
	}
	private List<String> list;
}