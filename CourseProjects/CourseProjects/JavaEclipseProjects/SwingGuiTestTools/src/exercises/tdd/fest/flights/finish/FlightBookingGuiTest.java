package exercises.tdd.fest.flights.finish;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import static org.fest.swing.fixture.TableCell.row;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlightBookingGuiTest {
	@Before
	public void start() {
		fixture = new FrameFixture(FlightBookingGUI.createGUI());
		fixture.show();
	}
	@Test
	public void airportsMustBeSelected() {
		fixture.button("searchButton").click();
		fixture.optionPane().requireMessage("Please choose airports!");
		fixture.optionPane().okButton().click();	
	}
	@Test
	public void selectedAirportsAreDisplayed() {
		enterValidDetails();
		//trigger the search
		fixture.button("searchButton").click();
		//check possible flights displayed
		String[][] contents = fixture.table("searchResultsTable").contents();
		assertEquals(5,contents.length);
		for(int i=0;i<contents.length;i++) {
			assertEquals("Belfast City",contents[i][0]);
			assertEquals("Heathrow",contents[i][1]);
			assertEquals("2008.03.05",contents[i][2]);
		}	
	}
	private void enterValidDetails() {
		fixture.list("originSelection").selectItem("Belfast City");
		fixture.list("destinationSelection").selectItem("Heathrow");
		fixture.comboBox("monthSelection").selectItem("March");
		fixture.comboBox("daySelection").selectItem("5");
	}
	@Test
	public void flightMustBeSelected() {
		enterValidDetails();
		//trigger the search
		fixture.button("searchButton").click();
		fixture.button("bookingButton").click();
		fixture.optionPane().requireMessage("Please choose a flight!");
		fixture.optionPane().okButton().click();	
	}
	@Test
	public void validBookingSucceeds() {
		enterValidDetails();
		//trigger the search
		fixture.button("searchButton").click();
		//book one of the flights
		fixture.table("searchResultsTable").selectCell(row(1).column(0));
		fixture.button("bookingButton").click();
		fixture.optionPane().requireMessage("Flight Booked!");
		fixture.optionPane().okButton().click();	
	}
	@After
	public void end() {
		fixture.cleanUp();
	}
	private FrameFixture fixture;
}
