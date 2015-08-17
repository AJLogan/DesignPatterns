using System;
using System.Xml;
using System.Xml.XPath;
using System.Xml.Xsl;
using System.IO;

namespace ExtensionObjects {
	class Program {
		static void Main(string[] args) {
			//A document class optimised for XPath
			XPathDocument inputDoc = new XPathDocument(@"..\..\input.xml");

			//The transformer object
			XslTransform stylesheet = new XslTransform();
			stylesheet.Load(@"..\..\addition.xslt");

			Accumulate adder = new Accumulate();
			XsltArgumentList xargs = new XsltArgumentList();
			xargs.AddExtensionObject("urn:adder",adder);

			stylesheet.Transform(inputDoc,xargs,File.Open("output.html",FileMode.Create),null);

			Console.WriteLine("Transformation Complete");
		}
	}
}
