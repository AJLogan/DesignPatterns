package patterns.visitor;

import java.util.*;

public class Document implements Visited {
	private List<Module> modules = new ArrayList<Module>();
	
	public void acceptVisitor(Visitor v) {
		v.visitDocumentStart(this);
		for(Module m : modules) {
			m.acceptVisitor(v);
		}
		v.visitDocumentEnd();
	}
	public Document() {
		super();
	}
	public void addModule(Module m) {
		modules.add(m);
	}
}
