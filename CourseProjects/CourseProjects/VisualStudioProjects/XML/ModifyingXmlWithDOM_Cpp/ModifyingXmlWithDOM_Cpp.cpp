#include "stdafx.h"

using namespace System;
using namespace System::Xml;

int main(array<System::String ^> ^args)
{
	// Create and load the document
	XmlDocument^ doc = gcnew XmlDocument();
	doc->Load("customer.xml");

	// Change the customers forename
	XmlNodeList^ forenameNodes = doc->GetElementsByTagName("Forename");
	forenameNodes[0]->InnerText = "Jane";

	// Change the customers title
	XmlElement^ parent = (XmlElement^)forenameNodes[0]->ParentNode;
	parent->SetAttribute("title","Mrs");

	// Change the customers surname
	XmlNodeList^ surnameNodes = doc->GetElementsByTagName("Surname");
	surnameNodes[0]->InnerText = "Smith";

	// Change the customers address
	XmlElement^ address = nullptr;
	XmlNodeList^ nodeList = doc->DocumentElement->ChildNodes;
	for each(XmlNode^ node in nodeList) {
		if(node->Name->Equals("Address")) {
			address = (XmlElement^)node;
		}
	}
	address->FirstChild->InnerText = "Connolly Street";
	address->LastChild->InnerText = "Dublin";

	// Display and print the document
	doc->Save("output.xml");
	Console::WriteLine("Modified document saved to 'output.xml'");
}
