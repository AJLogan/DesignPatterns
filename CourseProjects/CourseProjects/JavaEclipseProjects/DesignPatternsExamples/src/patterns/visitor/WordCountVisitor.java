package patterns.visitor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class WordCountVisitor implements Visitor {
	private BufferedWriter output;

	public WordCountVisitor(Writer w) {
		output = new BufferedWriter(w);
	}

	@Override
	public void visitDocumentStart(Document d) {
		write("...Wordcount Visitor...");
	}

	@Override
	public void visitDocumentEnd() {
		closeOutput();
	}

	@Override
	public void visitModuleStart(Module m) {
		write("Module Length is: " + m.toString().length() + " character.");
	}

	@Override
	public void visitModuleEnd() {}

	@Override
	public void visitSectionStart(Section s) {
		write("Section Length is: " + s.toString().length() + " character.");
	}

	@Override
	public void visitSectionEnd() {}

	@Override
	public void visitParagraphStart(Paragraph p) {
		write("Paragraph Length is: " + p.toString().length() + " characters.");
	}

	@Override
	public void visitParagraphEnd() {}

	@Override
	public void visitTitleStart(Title t) {
		write("Title Length is: " + t.toString().length() + " character.");
	}

	@Override
	public void visitTitleEnd() {}
	
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
