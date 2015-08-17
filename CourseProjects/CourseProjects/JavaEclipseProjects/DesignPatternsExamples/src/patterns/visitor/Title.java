package patterns.visitor;

public class Title implements Visited {
	private String text;
	public void acceptVisitor(Visitor v) {
		v.visitTitleStart(this);
		v.visitTitleEnd();
	}
	public Title(String text) {
		this.text = text;
	}
	public String toString() {
		return text;
	}
}
