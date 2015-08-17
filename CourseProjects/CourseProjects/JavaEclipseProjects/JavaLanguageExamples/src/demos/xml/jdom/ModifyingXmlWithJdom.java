package demos.xml.jdom;

import java.io.File;
import java.io.FileWriter;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class ModifyingXmlWithJdom {
	public static void main(String[] args) throws Exception {
		File fileToReadFrom = new File("output" + File.separator + "jdom_output.xml");
		File fileToSaveTo = new File("output" + File.separator + "jdom_modified_output.xml");
		
		//Build the JDOM document from SAX events
		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(fileToReadFrom);
		
		//Find the document element
		Element docElement = document.getRootElement();
		
		//Change the content of the Name element
		Element name = docElement.getChild("Name");
		name.setAttribute("title","Mrs");
		name.getChild("Forename").setText("Jane");
		name.getChild("Surname").setText("Smith");
		
		//Change the content of the Address element 
		Element address = docElement.getChild("Address");
		address.getChild("Street").setText("Connolly Street");
		address.getChild("City").setText("Dublin");
		
		//Save the document to a file and the console
		XMLOutputter out = new XMLOutputter();
		out.output(document,new FileWriter(fileToSaveTo));
		out.output(document,System.out);
	}

}
