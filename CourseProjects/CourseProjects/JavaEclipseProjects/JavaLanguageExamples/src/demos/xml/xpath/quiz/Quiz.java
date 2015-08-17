package demos.xml.xpath.quiz;

import java.io.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Quiz {
	public static void main(String[] args) throws Exception {
		markQuestions();
	}
	private static void markQuestions() throws IllegalAccessException, NoSuchFieldException, Exception {
		for(int i=1;i<=31;i++) {
			String question = (String)Questions.class.getField("Q" + i).get(null);
			String answer = (String)Solutions.class.getField("Q" + i).get(null);
			markQuestion(i,question,answer);
		}
	}
	private static void markQuestion(int number, String question, String answer) throws Exception {
		System.out.println("\nQuestion " + number);
		System.out.println("\tYour result:\t" + runXPath(question));
		System.out.println("\tRight result:\t" + runXPath(answer));
	}
	private static String runXPath(String xpathAsString) throws Exception {
		XPathFactory factory = 	XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		InputSource input = new InputSource(new FileReader("input/quiz_data.xml"));
		Node contextNode = (Node) xpath.evaluate("//*[@id='me']", input, XPathConstants.NODE);
		
		StringBuffer buffer = new StringBuffer();
		NodeList nodes = (NodeList) xpath.evaluate(xpathAsString, contextNode, XPathConstants.NODESET);
		for(int i=0;i<nodes.getLength();i++) {
			Node node = nodes.item(i);
			Element element = (Element)node;
			buffer.append(element.getAttribute("id"));
			buffer.append(" ");
		}
		return buffer.toString();
	}
}
