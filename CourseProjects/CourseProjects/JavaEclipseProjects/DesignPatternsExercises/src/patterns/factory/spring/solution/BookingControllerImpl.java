package patterns.factory.spring.solution;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("controller")
public class BookingControllerImpl implements BookingController {
    public BookingControllerImpl() {
        super();
    }
    public List<Flight> findAvailableFlights(String origin, String destination, Date departure) {
        return searchEngine.findFlights(origin, destination, departure);
    }
    public boolean bookFlight(Flight selected) {
        return bookingService.makeBooking(selected);
    }
	public FlightSearchEngine getSearchEngine() {
		return searchEngine;
	}
	@Resource(name="search")
	public void setSearchEngine(FlightSearchEngine searchEngine) {
		this.searchEngine = searchEngine;
	}
	public FlightBookingService getBookingService() {
		return bookingService;
	}
	@Resource(name="booking")
	public void setBookingService(FlightBookingService bookingService) {
		this.bookingService = bookingService;
	}
    private FlightSearchEngine searchEngine;
    private FlightBookingService bookingService;
}