using System;
using System.Xml;

namespace UsingDOM
{
	class Program {
		static void Main(string[] args) {
			// Create and load the document
			XmlDocument doc = new XmlDocument();
			doc.Load(@"..\..\customer.xml");

			// Change the customers forename
			XmlNodeList forenameNodes = doc.GetElementsByTagName("Forename");
			forenameNodes[0].InnerText = "Jane";

			// Change the customers title
			XmlElement parent = (XmlElement)forenameNodes[0].ParentNode;
			parent.SetAttribute("title","Mrs");

			// Change the customers surname
			XmlNodeList surnameNodes = doc.GetElementsByTagName("Surname");
			surnameNodes[0].InnerText = "Smith";

			// Change the customers address
			XmlElement address = null;
			XmlNodeList nodeList = doc.DocumentElement.ChildNodes;
			foreach(XmlNode node in nodeList) {
				if(node.Name.Equals("Address")) {
					address = (XmlElement)node;
				}
			}
			address.FirstChild.InnerText = "Connolly Street";
			address.LastChild.InnerText = "Dublin";

			// Display and print the document
			doc.Save("output.xml");
			Console.WriteLine("Modified document saved to 'output.xml'");
		}
	}
}
