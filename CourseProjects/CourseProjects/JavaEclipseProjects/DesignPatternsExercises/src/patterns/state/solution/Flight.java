package patterns.state.solution;

import java.util.*;

public class Flight {
    public Flight(String origin, String destination, Date departure) {
        super();
        chooseSeating(Seating.STANDARD_CLASS);
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
    }
    private void chooseSeating(Seating choice) {
        switch(choice) {
        		case FIRST_CLASS:
        		    seating = new FirstClassSeatingType();
        			break;
        		case BUSINESS_CLASS:
        		    seating = new BusinessClassSeatingType();
        			break;
        		case STANDARD_CLASS:
        		    seating = new StandardClassSeatingType();
        			break;
        		default:
        		    throw new IllegalStateException();
        }
    }
    public Date getDeparture() {
        return departure;
    }
    public String getDestination() {
        return destination;
    }
    public String getOrigin() {
        return origin;
    }
    public void setDeparture(Date departure) {
        this.departure = departure;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setSeating(Seating seating) {
        chooseSeating(seating);
    }
    public Seating getSeating() {
        return seating.value();
    }
    public double cost(Map<String,String> distances) {
        String key;
        if(origin.compareToIgnoreCase(destination) > 0) {
            key = destination + "-" + origin;
        } else {
            key = origin + "-" + destination;
        }
        int distance = Integer.parseInt(((String)distances.get(key)).trim());
        return seating.cost(distance);
    }
    private SeatingType seating;
    private String origin;
    private String destination;
    private Date departure;
}
