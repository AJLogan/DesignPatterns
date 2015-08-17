package demos.classes.polymorphism;

/**
 * @author Garth Gilmour
 *
 */
public class Tester {
	public static void main(String[] args) {

		Employee e1 = new Employee();
		Employee e2 = new Manager();
		Employee e3 = new Salesman();
		Employee e4 = new Consultant();

		e1.downsize();
		e2.downsize();
		e3.downsize();
		e4.downsize();

		//Employee[] people = {e1,e2,e3,e4};
		//fireAllEmployees(people);
	}
	public static void fireAllEmployees(Employee[] employees) {
		for(int i=0;i<employees.length;i++) {
			employees[i].downsize();
		}
	}
}
