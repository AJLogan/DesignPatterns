using System;
using System.Xml;
using System.Xml.XPath;
using System.Xml.Xsl;
using System.IO;

namespace SimpleTransform {
	class Program {
		static void Main(string[] args) {
			//A document class optimised for XPath
			XPathDocument inputDoc = new XPathDocument(@"..\..\muchAdoAboutNothing.xml");

			//The transformer object
			XslTransform stylesheet = new XslTransform();
			stylesheet.Load(@"..\..\shakespeare.xslt");

			//Perform a simple transformation 
			// Parameter two could be an XsltArgumentList object to pass parameters
			// Parameter four would be an XmlResolver if our XSLT used 'import' or 'include'
			stylesheet.Transform(inputDoc,null,File.Open("output.html",FileMode.Create),null);

			Console.WriteLine("Transformation Complete");
		}
	}
}
