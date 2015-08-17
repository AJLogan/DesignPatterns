#include "stdafx.h"

using namespace System;
using namespace System::Xml;
using namespace System::IO;
using namespace System::Text;

int main(array<System::String ^> ^args)	{
	//Create a new file to write to
	FileStream^ fs = nullptr;
	try {
		fs = File::Open("output.xml",FileMode::CreateNew);
	} catch(IOException^) {
		Console::WriteLine("File already exists!");
		return 0;
	}
	//Create a Writer object that understands XML
	XmlTextWriter^ writer = gcnew XmlTextWriter(fs,Encoding::UTF8);
	//Make sure our XML is formatted 'nicely'
	writer->Formatting = Formatting::Indented;
	//Write the XML declaration
	writer->WriteStartDocument();
	//Write the document element
	writer->WriteStartElement("person");
	//Add an attribute to the document element
	writer->WriteAttributeString("title","Mr");
	//Write two elements with text content
	writer->WriteElementString("forename","Joe");
	writer->WriteElementString("surname","Bloggs");
	//Write an address with nested elements
	writer->WriteStartElement("address");
	writer->WriteAttributeString("type","home");
	writer->WriteStartElement("street");
	writer->WriteAttributeString("no","10");
	writer->WriteString("Arcatia Road");
	writer->WriteEndElement();	//end of street
	writer->WriteElementString("city","Belfast");
	writer->WriteEndElement();	//end of address
	//End of document element
	writer->WriteEndElement();
	//End of XML document
	writer->WriteEndDocument();
	//Flush and close stream
	writer->Flush();
	writer->Close();

	Console::WriteLine("Finished writing XML");
}
