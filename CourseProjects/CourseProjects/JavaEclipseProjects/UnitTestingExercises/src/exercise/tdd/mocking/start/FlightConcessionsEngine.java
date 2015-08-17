package exercise.tdd.mocking.start;

public interface FlightConcessionsEngine {
	boolean additionalBenefitApplies(int numFlights, double totalCost);
	double calculateBenefit(int numFlights, double totalCost);
}
