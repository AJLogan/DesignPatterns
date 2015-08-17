package exercise.tdd.dao.exercise;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

import exercise.tdd.dao.shared.Employee;
import exercise.tdd.dao.shared.EmployeeManager;



public class EmployeeManagerImpl implements EmployeeManager {
	public EmployeeManagerImpl(String filePath) throws IOException {
		super();
	}
	public void close() throws IOException {
	}
	public Employee create(String name, int age, double salary) throws IOException {
		return null;
	}
	public void delete(Employee emp) throws IOException {
	}
	public Employee find(int id) throws IOException {
		return null;
	}
	public void update(Employee emp) throws IOException {
	}
	private HashMap<Integer,Long> locations;
	private RandomAccessFile file;
	private int nextId;
}
