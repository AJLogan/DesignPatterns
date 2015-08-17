package patterns.factory.spring.start;

import java.util.*;

public class Launcher {
    public static void main(String[] args) throws Exception {
    	String path = "patterns/factory/spring/start/labels.properties";
    	Properties p = new Properties();
    	p.load(Launcher.class.getClassLoader().getResourceAsStream(path));
    	
    	FlightsTableModel resultsModel = new FlightsTableModel();
    	
    	List<Flight> specialFlights = new ArrayList<Flight>();
    	specialFlights.add(new Flight("Dublin","New York",new Date()));
    	specialFlights.add(new Flight("Dublin","Paris",new Date()));
    	specialFlights.add(new Flight("Dublin","Barcelona",new Date()));			   
    	
    	FlightsTableModel specialOffersModel = new FlightsTableModel(specialFlights);
    	
    	String [] months = { 
    						"January", "February", "March", "April", "May",
    						"June", "July", "August", "September", "October",
    						"November", "December"
    					   };
    	
    	Integer [] days = {
							1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,   						
							18,19,20,21,22,23,24,25,26,27,28,29,30,31
    				  	  };
    	
    	List<String> airports = new ArrayList<String>();
    	airports.add("Heathrow");
    	airports.add("Belfast International");
    	airports.add("Belfast City");
    	airports.add("Dublin");
    	airports.add("Birmingham");
    	airports.add("Luton");
    	
    	FlightsListModel airportsModel = new FlightsListModel(airports);
    	
    	BookingController controller = new BookingController();
    	
    	FlightBookingGUI gui = new FlightBookingGUI(resultsModel,
    												specialOffersModel,
    												airportsModel,
    												months,
    												days,
    												p.getProperty("origin.airport.label.text"),
    												p.getProperty("destination.airport.label.text"),
    												p.getProperty("month.label.text"),
    												p.getProperty("day.label.text"),
    												p.getProperty("search.button.text"),
    												p.getProperty("booking.button.text"));
    	gui.setController(controller);										
        gui.setVisible(true);
    }
}
