package demos.xml.jdom;

import java.io.*;

import org.jdom.*;
import org.jdom.output.*;

public class CreatingXmlWithJdom {
	public static void main(String[] args) throws IOException {
		//Create a new document with a comment and document element
		Document document = new Document();
		document.addContent(new Comment("This document describes a customer"));
		Element docElement = new Element("Customer");
		document.addContent(docElement);
		
		//Create the name element with content
		Element name = new Element("Name");
		name.setAttribute("title","Mr");
		name.addContent(new Element("Forename").addContent("Joe"));
		name.addContent(new Element("Surname").addContent("Bloggs"));
		
		//Create the address element with content
		Element address = new Element("Address");
		address.setAttribute("postcode","BT37 ABC");
		Element street = new Element("Street");
		street.setAttribute("number","27");
		street.addContent("University Street");
		address.addContent(street);
		address.addContent(new Element("City").addContent("Belfast"));
		
		//Add the name and address element to the 'customer' element
		docElement.addContent(name);
		docElement.addContent(address);
		
		//Save the document to a file and the console
		XMLOutputter out = new XMLOutputter();
		File fileToSaveTo = new File("output" + File.separator + "jdom_output.xml");
		out.output(document,new FileWriter(fileToSaveTo));
		out.output(document,System.out);
	}

}
