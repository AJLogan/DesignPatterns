package patterns.state.solution;

class BusinessClassSeatingType extends SeatingType {
    double cost(int distance) {
        double cost = 300;
        if(distance > 200) {
            cost += distance * 0.40;
        } else {
            cost += distance * 0.30;
        }
        return cost;
    }
    Seating value() {
        return Seating.BUSINESS_CLASS;
    }

}
