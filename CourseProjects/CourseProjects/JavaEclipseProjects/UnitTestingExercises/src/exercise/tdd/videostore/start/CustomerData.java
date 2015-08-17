package exercise.tdd.videostore.start;

import java.util.List;

public class CustomerData {
	public String customer;
	public List<Rental> rentals;

	public CustomerData(List<Rental> rentals) {
		this.rentals = rentals;
	}
}