package patterns.visitor;

import java.util.*;

public class Module implements Visited {
	private List<Section> sections = new ArrayList<Section>();
	 
	public void acceptVisitor(Visitor v) {
		v.visitModuleStart(this);
		for(Section s : sections) {
			s.acceptVisitor(v);
		}
		v.visitModuleEnd();
	}
	public Module() {
		super();
	}
	public void addSection(Section s) {
		sections.add(s);
	}
}
