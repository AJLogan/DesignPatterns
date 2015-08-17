using System;
using System.Xml;
using System.Xml.Schema;

namespace SchemaValidation {
	class Program {
		static void Main(string[] args) {
			string goodDocumentPath = @"../../purchase_order.xml";
			string badDocumentPath = @"../../purchase_order_bad.xml";
			string schemaPath = @"../../purchase_order.xsd";

			ValidateDocument(goodDocumentPath, schemaPath);
			ValidateDocument(badDocumentPath, schemaPath);
		}
		private static void ValidateDocument(string documentPath, string schemaPath) {
			Console.WriteLine("Trying to validate {0}", documentPath);

			XmlValidatingReader reader = new XmlValidatingReader(new XmlTextReader(documentPath));
			reader.ValidationType = ValidationType.Schema;
			reader.Schemas.Add(null, new XmlTextReader(schemaPath));
			reader.ValidationEventHandler += new ValidationEventHandler(Program.Error);

			while (reader.Read()) {
				//do nothing as we are only consuming the document to validate it
				// 'new XmlDocument().Load(reader);' would be another option...
			}

			if (validationFlag) {
				Console.WriteLine("\tDocument validated!\n");
			}
			else {
				Console.WriteLine("\tDocument failed to validate!\n");
			}
		}
		private static void Error(object sender, ValidationEventArgs e) {
			Console.WriteLine("Error validating against schema: {0}", e.Message);
			validationFlag = false;
		}
		private static bool validationFlag = true;
	}
}