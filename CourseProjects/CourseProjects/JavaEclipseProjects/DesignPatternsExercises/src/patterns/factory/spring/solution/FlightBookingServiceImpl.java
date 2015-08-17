package patterns.factory.spring.solution;

import org.springframework.stereotype.Component;

@Component("booking")
public class FlightBookingServiceImpl implements FlightBookingService {
    public boolean makeBooking(Flight selected) {
    	return true;
    }
}
