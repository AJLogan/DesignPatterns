package inheritance.finish;

public class Demo {
	public static void main(String[] args) {
		Student s1 = new Student("Joe Bloggs","Philosophy",3,new double[] {65.4,66.5,72.2});
		Student s2 = new GraduateStudent("Jane Smith","Computer Science",2,new double[] {78.2,80.5},8,"Dr Harris");

		System.out.println(s1);
		System.out.println(s2);
	}
}
