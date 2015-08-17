using System;

namespace XMLReaderDemo {
	public class Program {
		static void Main(string[] args) {
			string fileName = @"..\..\config.xml";
			ConfigReader cr = new ConfigReader(fileName);
			cr.printUsers();
		}
	}
}
