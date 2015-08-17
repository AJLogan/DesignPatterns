package patterns.state.solution;

public class FirstClassSeatingType extends SeatingType {
    double cost(int distance) {
        double cost = 500;
        if(distance > 200) {
            cost += distance * 0.60;
        } else {
            cost += distance * 0.50;
        }
        return cost;
    }
    Seating value() {
        return Seating.FIRST_CLASS;
    }

}
