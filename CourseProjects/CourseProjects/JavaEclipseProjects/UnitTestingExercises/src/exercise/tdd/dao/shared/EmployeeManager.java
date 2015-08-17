package exercise.tdd.dao.shared;

import java.io.IOException;


public interface EmployeeManager {

	int STARTING_ID = 123;

	Employee create(String name, int age, double salary) throws IOException;

	Employee find(int id) throws IOException;

	void delete(Employee emp) throws IOException;

	void update(Employee emp) throws IOException;

	void close() throws IOException;

}