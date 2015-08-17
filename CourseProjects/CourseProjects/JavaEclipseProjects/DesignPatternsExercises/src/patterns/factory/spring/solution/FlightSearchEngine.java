package patterns.factory.spring.solution;

import java.util.Date;
import java.util.List;

public interface FlightSearchEngine {

	List<Flight> findFlights(String origin, String destination, Date departure);

}