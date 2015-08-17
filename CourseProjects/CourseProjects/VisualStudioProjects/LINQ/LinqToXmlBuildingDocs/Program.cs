using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using System.Text;

namespace LinqToXmlBuildingDocs {
    class Program {
        static void Main(string[] args) {
            XDocument document = new XDocument();

            XElement docElement = new XElement("Customer");
            document.Add(docElement);

            XElement name = new XElement("Name",new XAttribute("title", "Mr"));
            name.Add(new XElement("Forename",new XText("Joe")));
            name.Add(new XElement("Surname", new XText("Bloggs")));

            XElement address = new XElement("Address", new XAttribute("title", "Mr"));
            address.Add(new XElement("Street", new XText("Univeristy Street"), new XAttribute("number",11)));
            address.Add(new XElement("City", new XText("Belfast")));

            docElement.Add(name);
            docElement.Add(address);

            document.Save("output.xml");
            Console.WriteLine("Document built and saved to 'output.xml'");
        }
    }
}
