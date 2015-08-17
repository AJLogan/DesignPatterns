package patterns.visitor;

import java.io.*;

public class HTMLFormatVisitor implements Visitor {
	private BufferedWriter output;

	public HTMLFormatVisitor(Writer w) {
		output = new BufferedWriter(w);
	}

	public void visitDocumentStart(Document d) {
		write("<html><head/><body>");
	}
	public void visitDocumentEnd() {
		write("</body></html>");
		closeOutput();
	}
	public void visitModuleStart(Module m) {
		write("<h2>New Module</h2>");
	}
	public void visitModuleEnd() {}
	public void visitParagraphStart(Paragraph p) {
		write("<p>" + p + "</p>");
	}
	public void visitParagraphEnd(){}
	public void visitSectionStart(Section s) {
		write("<h3>New Section</h3>");
	}
	public void visitSectionEnd() {}
	public void visitTitleStart(Title title) {
		write("<h4>" + title + "</h4>");
	}
	public void visitTitleEnd(){}
	private void write(String text) {
		try {
			output.write(text);
			output.newLine();
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}
	private void closeOutput() {
		try {
			output.close();
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}
}
