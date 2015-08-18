package patterns.visitor;

import java.util.*;

public class Section implements Visited {
	@SuppressWarnings("unused")
	private Title title;
	private List<Paragraph> paragraphs = new ArrayList<Paragraph>();
	
	public void acceptVisitor(Visitor v) {
		v.visitSectionStart(this);
		title.acceptVisitor(v);
		for(Paragraph p : paragraphs) {
			p.acceptVisitor(v);
		}
		v.visitSectionEnd();
	}
	public Section(Title title) {
		this.title = title;
	}
	public void addParagraph(Paragraph p) {
		paragraphs.add(p);
	}
}
