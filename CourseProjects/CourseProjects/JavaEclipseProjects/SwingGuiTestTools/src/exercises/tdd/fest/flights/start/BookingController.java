package exercises.tdd.fest.flights.start;

import java.util.Date;
import java.util.List;

public interface BookingController {
	List<Flight> findAvailableFlights(String origin, String destination, Date departure);
	boolean bookFlight(Flight selected);
}