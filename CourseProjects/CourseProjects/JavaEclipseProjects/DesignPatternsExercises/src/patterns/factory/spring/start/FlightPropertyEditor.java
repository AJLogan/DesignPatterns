package patterns.factory.spring.start;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FlightPropertyEditor extends PropertyEditorSupport {
	@Override
	public String getAsText() {
		return getValue().toString();
	}
	@Override
	public void setAsText(String param) throws IllegalArgumentException {
		String [] parts = param.split("#");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		Date d;
		try {
			d = df.parse(parts[2]);
		} catch(Exception ex) {
			d = new Date();
		}
		Flight flight = new Flight(parts[0],parts[1],d);
		setValue(flight);
	}
}
