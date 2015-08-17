using System;
using System.IO;
using System.Text;
using System.Xml.XPath;

namespace XPathQuiz {
	class Program {
		static void Main(string[] args) {
			FileInfo f = new FileInfo(@"..\..\quiz_data.xml");
			XPathDocument document = new XPathDocument(f.OpenRead());
			XPathNavigator startingPoint = GetStartingNode(document);

			Type t1 = typeof (Questions);
			Type t2 = typeof (Solutions);
			
			for(int i=1;i<=31;i++) {
				string question = (string)t1.GetField("Q" + i).GetValue(null);
				string answer = (string)t2.GetField("Q" + i).GetValue(null);
				markQuestion(startingPoint,i,question,answer);
			}
			
		}

		private static XPathNavigator GetStartingNode(XPathDocument document) {
			XPathNavigator navigator = document.CreateNavigator();
			XPathExpression pathToCurrentNode = navigator.Compile("//*[@id='me']");
			XPathNodeIterator iterator = navigator.Select(pathToCurrentNode);
			iterator.MoveNext();
			return iterator.Current;
		}

		private static void markQuestion(XPathNavigator navigator, int number, string question, string answer) {
			//Console.WriteLine("Trying {0} with {1} and {2}", number, question, answer);
			
			XPathNodeIterator iterator1 = navigator.Select(question);
			XPathNodeIterator iterator2 = navigator.Select(answer);
			
			Console.WriteLine("\nQuestion {0}:",number);
			Console.WriteLine("\tYour results: {0}",GetResults(iterator1));
			Console.WriteLine("\tRight results: {0}",GetResults(iterator2));
			
		}

		private static string GetResults(XPathNodeIterator iterator) {
			StringBuilder sb = new StringBuilder();
			while(iterator.MoveNext()) {
				XPathNavigator navigator = iterator.Current;
				sb.Append(navigator.GetAttribute("id",""));
				sb.Append(" ");
			}
			return sb.ToString();
		}
	}
}