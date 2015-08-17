package patterns.state.solution;

class StandardClassSeatingType extends SeatingType {
    double cost(int distance) {
        double cost = 250;
        if(distance > 200) {
            cost += distance * 0.20;
        } else {
            cost += distance * 0.10;
        }
        return cost;
    }
    Seating value() {
        return Seating.STANDARD_CLASS;
    }
}
