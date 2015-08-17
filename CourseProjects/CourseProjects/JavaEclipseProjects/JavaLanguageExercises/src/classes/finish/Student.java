package classes.finish;

public class Student {
	public Student(String name, String courseTitle, int yearOfStudy, double[] marks) {
		this.courseTitle = courseTitle;
		this.marks = marks;
		this.name = name;
		this.yearOfStudy = yearOfStudy;
	}
	public double average() {
		double total = 0;
		for(int i=0;i<marks.length;i++) {
			total += marks[i];
		}
		return total / marks.length;
	}
	public String toString() {
		StringBuffer msg = new StringBuffer();
		msg.append(name);
		msg.append(" studying ");
		msg.append(courseTitle);
		msg.append(" in year ");
		msg.append(yearOfStudy);
		msg.append(" with results");
		for(int i=0;i<marks.length;i++) {
			msg.append(" ");
			msg.append(marks[i]);
		}
		return msg.toString();
	}
	private String name;
	private String courseTitle;
	private int yearOfStudy;
	private double [] marks;
	
}
