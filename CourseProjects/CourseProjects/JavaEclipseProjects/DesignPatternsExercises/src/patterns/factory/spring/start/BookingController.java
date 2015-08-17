package patterns.factory.spring.start;

import java.util.*;

public class BookingController {
    public BookingController() {
        super();
        searchEngine = new FlightSearchEngine();
        bookingService = new FlightBookingService();
    }
    public List<Flight> findAvailableFlights(String origin, String destination, Date departure) {
        return searchEngine.findFlights(origin, destination, departure);
    }
    public boolean bookFlight(Flight selected) {
        return bookingService.makeBooking(selected);
    }
    private FlightSearchEngine searchEngine;
    private FlightBookingService bookingService;
}