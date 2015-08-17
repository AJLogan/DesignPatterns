package patterns.state.start;

import java.util.*;

public class Flight {
    public Flight(String origin, String destination, Date departure) {
        super();
        seating = Seating.STANDARD_CLASS;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
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
        this.seating = seating;
    }
    public Seating getSeating() {
        return seating;
    }
    public double cost(Map<String,String> distances) {
        String key;
        if(origin.compareToIgnoreCase(destination) > 0) {
            key = destination + "-" + origin;
        } else {
            key = origin + "-" + destination;
        }
        int distance = Integer.parseInt((distances.get(key)).trim());
        double cost = 0;
        switch(seating) {
        case FIRST_CLASS:
            cost = 500;
            if(distance > 200) {
                cost += distance * 0.60;
            } else {
                cost += distance * 0.50;
            }
            break;
        case BUSINESS_CLASS:
            cost = 300;
            if(distance > 200) {
                cost += distance * 0.40;
            } else {
                cost += distance * 0.30;
            }
            break;
        case STANDARD_CLASS:
            cost = 250;
            if(distance > 200) {
                cost += distance * 0.20;
            } else {
                cost += distance * 0.10;
            }
            break;
        default:
            throw new IllegalStateException();
        }
        return cost;
    }
    private Seating seating;
    private String origin;
    private String destination;
    private Date departure;
}
