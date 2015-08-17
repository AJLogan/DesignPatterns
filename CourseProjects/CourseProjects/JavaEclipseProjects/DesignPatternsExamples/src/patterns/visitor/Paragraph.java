package patterns.visitor;

public class Paragraph implements Visited {
	private String text; 
	public void acceptVisitor(Visitor v) {
		v.visitParagraphStart(this);
		v.visitParagraphEnd();
	}
	public Paragraph(String text) {
		this.text = text;
	}
	public String toString() {
		return text;
	}
}
