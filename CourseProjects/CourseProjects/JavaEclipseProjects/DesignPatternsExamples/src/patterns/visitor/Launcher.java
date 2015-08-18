package patterns.visitor;

import java.io.*;

public class Launcher {

	public static void main(String[] args) throws IOException {
		Document doc = buildDocument();
		
		Visitor v1 = new HTMLFormatVisitor(new FileWriter("output" + File.separator + "visitor.html"));
		doc.acceptVisitor(v1);
		
		Visitor v2 = new XMLFormatVisitor(new FileWriter("output" + File.separator + "visitor.xml"));
		doc.acceptVisitor(v2);
		
		Visitor v3 = new WordCountVisitor(new FileWriter("output" + File.separator + "wordCount.xml"));
		doc.acceptVisitor(v3);
		
		System.out.println("Reports generated");
	}

	private static Document buildDocument() {
		Section s1 = new Section(new Title("Section One"));
		s1.addParagraph(new Paragraph("Paragraph One"));
		s1.addParagraph(new Paragraph("Paragraph Two"));
		
		Section s2 = new Section(new Title("Section Two"));
		s2.addParagraph(new Paragraph("Paragraph Three"));
		s2.addParagraph(new Paragraph("Paragraph Four"));
		
		Section s3 = new Section(new Title("Section Three"));
		s3.addParagraph(new Paragraph("Paragraph Five"));
		s3.addParagraph(new Paragraph("Paragraph Six"));
		
		Section s4 = new Section(new Title("Section Four"));
		s4.addParagraph(new Paragraph("Paragraph Seven"));
		s4.addParagraph(new Paragraph("Paragraph Eight"));
		
		Module m1 = new Module();
		m1.addSection(s1);
		m1.addSection(s2);
		
		Module m2 = new Module();
		m2.addSection(s3);
		m2.addSection(s4);
		
		Document doc = new Document();
		doc.addModule(m1);
		doc.addModule(m2);
		return doc;
	}
}
