using System;
using System.IO;
using System.Xml.XPath;

namespace RunningQueries {
	class Program {
		[STAThread]
		static void Main(string[] args) {
			FileInfo f = new FileInfo(@"..\..\purchase_order.xml");
			if(!f.Exists) {
				throw new Exception("XML File does not exist!");
			}
			StreamReader reader = f.OpenText();
			XPathDocument document = new XPathDocument(reader);
			XPathNavigator navigator = document.CreateNavigator();
			
			/*
			 * Show how to run absolute expressions
			 * 
			 */
	
			XPathExpression[] absoluteExpressions = new XPathExpression[5];
			absoluteExpressions[0] = navigator.Compile("/purchaseOrder/customer/address/@postcode");
			absoluteExpressions[1] = navigator.Compile("/purchaseOrder/customer/paymentOptions/category");
			absoluteExpressions[2] = navigator.Compile("/purchaseOrder/itemsList/item[1]/description/text()");
			absoluteExpressions[3] = navigator.Compile("/purchaseOrder/itemsList/item[last()]/description/text()");
			absoluteExpressions[4] = navigator.Compile("/purchaseOrder/itemsList/item/description");
			
			Console.WriteLine("Results of absolute expressions are:");
			RunQueries(absoluteExpressions, navigator);
			
			/*
			 * Show how to run relative expressions
			 * 
			 */
			
			XPathExpression [] relativeExpressions = new XPathExpression[5];
			relativeExpressions[0] = navigator.Compile("preceding-sibling::item");
			relativeExpressions[1] = navigator.Compile("following-sibling::item");
			relativeExpressions[2] = navigator.Compile("preceding-sibling::item[1]/description");
			relativeExpressions[3] = navigator.Compile("following-sibling::item[1]/description");
			relativeExpressions[4] = navigator.Compile("description/text()");
			
			XPathExpression pathToCurrentNode = navigator.Compile("/purchaseOrder/itemsList/item[@index = 5]");
			XPathNodeIterator iterator = navigator.Select(pathToCurrentNode);
			iterator.MoveNext();
			Console.WriteLine("Results of relative expressions are:");
			RunQueries(relativeExpressions, iterator.Current);
			
			/*
			 * Show how to run expressions that return numbers
			 * 
			 */
			double result = (double)navigator.Evaluate("count(/purchaseOrder/itemsList/item)");
			Console.WriteLine("Counting query returned {0}",result);
		}

		private static void RunQueries(XPathExpression[] expressions, XPathNavigator navigator) {
			for(int i=0; i<expressions.Length; i++) {
				XPathExpression query = expressions[i];
				XPathNodeIterator iterator = navigator.Select(query);
				Console.WriteLine("\tResults for query {0} are:",i);
				while(iterator.MoveNext()) {
					XPathNavigator current = iterator.Current;
					if(current.NodeType == XPathNodeType.Element) {
						Console.WriteLine("\t\tElement called {0} with value {1}",current.Name,current.Value);
					} else {
						Console.WriteLine("\t\tNode with value {0}",current.Value);
					}
				}
			}
		}
	}
}