package patterns.visitor;

import java.io.*;

public class XMLFormatVisitor implements Visitor {
	private BufferedWriter output;

	public XMLFormatVisitor(Writer w) {
		if(w instanceof BufferedWriter) {
			output = (BufferedWriter)w;
		} else {
			output = new BufferedWriter(w);
		}	
	}
	public void visitDocumentStart(Document d) {
		write("<document>");
	}
	public void visitDocumentEnd() {
		write("<document>");
		closeOutput();
	}
	public void visitModuleStart(Module m) {
		write("<module>");
	}
	public void visitModuleEnd() {
		write("</module>");
	}
	public void visitParagraphStart(Paragraph p) {
		write("<paragraph>");
		write(p.toString());
	}
	public void visitParagraphEnd(){
		write("</paragraph>");
	}
	public void visitSectionStart(Section s) {
		write("<section>");
	}
	public void visitSectionEnd() {
		write("</section>");
	}
	public void visitTitleStart(Title title) {
		write("<title>");
		write(title.toString());
	}
	public void visitTitleEnd(){
		write("</title>");
	}
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
