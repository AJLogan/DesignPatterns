using System;
using System.Xml;
using System.Xml.XPath;
using System.Xml.Xsl;
using System.IO;

namespace TemplateParams {
	class Program {
		static void Main(string[] args) {
			//A document class optimised for XPath
			XPathDocument inputDoc = new XPathDocument(new StringReader("<title>A Simple Barchart</title>"));

			//The transformer object
			XslTransform stylesheet = new XslTransform();
			stylesheet.Load(@"..\..\barchart.xslt");

			XsltArgumentList xargs = new XsltArgumentList();
			xargs.AddParam("r1","",50);
			xargs.AddParam("r2","",70);
			xargs.AddParam("r3","",90);
			xargs.AddParam("r4","",110);
			xargs.AddParam("r5","",130);
			
			stylesheet.Transform(inputDoc,xargs,File.Open("output.svg",FileMode.Create),null);

			Console.WriteLine("Transformation Complete");
		}
	}
}
