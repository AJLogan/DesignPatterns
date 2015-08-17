#include "stdafx.h"

using namespace System;
using namespace System::Xml;

int main(array<System::String ^> ^args) {
	XmlDocument^ doc = gcnew XmlDocument();

	// Add a comment to the document
	doc->AppendChild(doc->CreateComment("This document describes a customer"));

	//Create and set the Document Element
	XmlElement^ docElement = doc->CreateElement("Customer");
	doc->AppendChild(docElement);

	//Create some children with attributes
	XmlElement^ name = doc->CreateElement("Name");
	name->SetAttribute("title","Mr");
	XmlElement^ address = doc->CreateElement("Address");
	address->SetAttribute("postcode",L"BT37 ABC");

	//Add the children to the document element
	docElement->AppendChild(name);
	docElement->AppendChild(address);

	// Fill out the name element
	XmlElement^ forename = doc->CreateElement("Forename");
	forename->InnerText = "Joe";
	XmlElement^ surname = doc->CreateElement("Surname");
	surname->InnerText = "Bloggs";

	name->AppendChild(forename);
	name->AppendChild(surname);

	//Fill out the street element
	XmlElement^ street = doc->CreateElement("Street");
	street->InnerText = "University Street";
	street->SetAttribute("number", "27");
	XmlElement^ city = doc->CreateElement("City");
	city->InnerText = "Belfast";

	address->AppendChild(street);
	address->AppendChild(city);

	//Save the document
	doc->Save("output.xml");
	Console::WriteLine("Document built and saved to 'output.xml'");
}
