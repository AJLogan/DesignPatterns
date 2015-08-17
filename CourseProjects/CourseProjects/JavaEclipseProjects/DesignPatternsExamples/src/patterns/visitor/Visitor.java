package patterns.visitor;


public interface Visitor {
	void visitDocumentStart(Document d);
	void visitDocumentEnd();
	void visitModuleStart(Module m);
	void visitModuleEnd();
	void visitSectionStart(Section s);
	void visitSectionEnd();
	void visitParagraphStart(Paragraph p);
	void visitParagraphEnd();
	void visitTitleStart(Title t);
	void visitTitleEnd();
}
