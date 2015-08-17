package exercise.tdd.mocking.finish.mockito;

public interface FlightConcessionsEngine {
	boolean additionalBenefitApplies(int numFlights, double totalCost);
	double calculateBenefit(int numFlights, double totalCost);
}
