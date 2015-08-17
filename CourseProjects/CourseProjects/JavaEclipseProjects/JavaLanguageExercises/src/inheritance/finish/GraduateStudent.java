package inheritance.finish;

public class GraduateStudent extends Student {
	public GraduateStudent(String name, String subject, int yearOfStudy, double[] marks, 
							int teachingHours, String supervisor) {
		super(name, subject, yearOfStudy, marks);
		this.teachingHours = teachingHours;
		this.supervisor = supervisor;
	}
	public String toString() {
		StringBuffer msg = new StringBuffer();
		msg.append("Graduate student ");
		msg.append(super.toString());
		msg.append(" teaching ");
		msg.append(teachingHours);
		msg.append(" hours under supervision of ");
		msg.append(supervisor);
		return msg.toString();
	}
	private int teachingHours;
	private String supervisor;
}
