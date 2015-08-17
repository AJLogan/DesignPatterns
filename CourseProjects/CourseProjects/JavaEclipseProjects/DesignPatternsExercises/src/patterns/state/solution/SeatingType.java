package patterns.state.solution;

abstract class SeatingType {
    abstract double cost(int distance);
    abstract Seating value();
}
