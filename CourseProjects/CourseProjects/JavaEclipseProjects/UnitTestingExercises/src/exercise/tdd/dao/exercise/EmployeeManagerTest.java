package exercise.tdd.dao.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import exercise.tdd.dao.shared.Employee;
import exercise.tdd.dao.shared.EmployeeManager;



public class EmployeeManagerTest {
	private static final String FILE_NAME = "data" + File.separator + "records.data";

	@Before
	public void start() throws Exception {
		File f = new File(FILE_NAME);
		if(f.exists()) {
			f.delete();
		}
		dao = new EmployeeManagerImpl(FILE_NAME);
		employees = new Employee[3];
		employees[0] = dao.create("Dave",27,30000.0);
		employees[1] = dao.create("Jane",28,40000.0);
		employees[2] = dao.create("Fred",29,50000.0);
	}
	@After
	public void end() throws Exception {
		dao.close();
	}
	@Test
	@Ignore
	public void createAssignsAscendingIds() {
		int i = EmployeeManager.STARTING_ID;
		assertEquals(i++,employees[0].getId());
		assertEquals(i++,employees[1].getId());
		assertEquals(i,employees[2].getId());
	}
	@Test
	@Ignore
	public void createBuildsEmployees() {
		checkEmployees();
	}
	@Test
	@Ignore
	public void findRetrievesEmployees() throws Exception {
		int i = EmployeeManager.STARTING_ID;
		employees[0] = dao.find(i++);
		employees[1] = dao.find(i++);
		employees[2] = dao.find(i);

		checkEmployees();
	}
	@Test
	@Ignore
	public void findByInvalidIdFails() throws Exception {
		assertNull(dao.find(999));
	}
	@Test
	@Ignore
	public void findRetrievesEmployeesInAnyOrder() throws Exception {
		int i = EmployeeManager.STARTING_ID;
		employees[2] = dao.find(i + 2);
		employees[1] = dao.find(i + 1);
		employees[0] = dao.find(i);

		checkEmployees();
	}
	@Test
	@Ignore
	public void findRetrievesEmployeesAcrossManagers() throws Exception {
		dao.close();
		dao = new EmployeeManagerImpl(FILE_NAME);

		int i = EmployeeManager.STARTING_ID;
		employees[0] = dao.find(i++);
		employees[1] = dao.find(i++);
		employees[2] = dao.find(i);

		checkEmployees();
	}
	@Test
	@Ignore
	public void createBuildsEmployeesAcrossManagers() throws Exception {
		dao.close();
		dao = new EmployeeManagerImpl(FILE_NAME);

		dao.create("Liza", 30, 60000.0);
		Employee emp = dao.find(EmployeeManager.STARTING_ID + 3);
		assertEmployeeDetails(emp,"Liza",30,60000.0);
		
		dao.close();
		dao = new EmployeeManagerImpl(FILE_NAME);
		
		emp = dao.find(EmployeeManager.STARTING_ID + 3);
		assertEmployeeDetails(emp,"Liza",30,60000.0);
	}
	@Test
	@Ignore
	public void deleteRemovesEmployees() throws Exception {
		dao.delete(employees[1]);
		assertNull(dao.find(employees[1].getId()));
	}
	@Test
	@Ignore
	public void deleteRemovesEmployeesAcrossManagers() throws Exception {
		dao.delete(employees[1]);

		dao.close();
		dao = new EmployeeManagerImpl(FILE_NAME);

		assertNull(dao.find(employees[1].getId()));
	}
	@Test
	@Ignore
	public void updateChangesEmployeesDetails() throws Exception {
		employees[0].setName("David");
		employees[0].setAge(32);
		employees[0].setSalary(60000.0);
		
		dao.update(employees[0]);
		assertEmployeeDetails(employees[0],"David",32,60000.0);
	}
	@Test
	@Ignore
	public void updateMakesChangesAcrossManagers() throws Exception {
		employees[0].setName("David");
		employees[0].setAge(32);
		employees[0].setSalary(60000.0);
		dao.update(employees[0]);
		
		dao.close();
		dao = new EmployeeManagerImpl(FILE_NAME);

		Employee emp = dao.find(employees[0].getId());
		assertEmployeeDetails(emp,"David",32,60000.0);
	}
	private void checkEmployees() {
		assertEmployeeDetails(employees[0],"Dave",27,30000.0);
		assertEmployeeDetails(employees[1],"Jane",28,40000.0);
		assertEmployeeDetails(employees[2],"Fred",29,50000.0);
	}
	private void assertEmployeeDetails(Employee emp, String name, int age, double salary) {
		assertEquals(name,emp.getName());
		assertEquals(age,emp.getAge());
		assertEquals(salary,emp.getSalary(),0.01);
	}
	private EmployeeManager dao;
	private Employee [] employees;
}

