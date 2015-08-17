/**
 * 
 */
package demos.swing.events.properties;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyListener implements PropertyChangeListener {
	public MyListener(MyListModel listModel) {
		super();
		this.listModel = listModel;
	}
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String name = event.getPropertyName();
		String oldValue = "none";
		if(event.getOldValue() != null) {
			oldValue = event.getOldValue().toString();
		}
		String newValue = "none";
		if(event.getNewValue() != null) {
			newValue = event.getNewValue().toString();
		}
		String message = "Property %s changed from %s to %s";
		listModel.add(String.format(message, name, oldValue, newValue));
		System.out.println(String.format(message, name, oldValue, newValue));
	}
	private MyListModel listModel;
}