using System;

namespace Exceptions {
	class Tester {
		static void Main(string[] args) {
			Console.WriteLine("Start of main");
			Op1();
			Console.WriteLine("End of main");
		}
		private static void Op1() {
			Console.WriteLine("\tStart of Op1");
			try {
				Op2();
			}
			catch (ArgumentException ex) {
				Console.WriteLine("1 Just caught: {0}", ex.GetType().Name);
			}
			catch (ArithmeticException ex) {
				Console.WriteLine("2 Just caught: {0}", ex.GetType().Name);
			}
			finally {
				Console.WriteLine("IN FINALLY");
			}
			Console.WriteLine("\tEnd of Op1");
		}
		private static void Op2() {
			Console.WriteLine("\t\tStart of Op2");
			Op3();
			Console.WriteLine("\t\tEnd of Op2");
		}
		private static void Op3() {
			Console.WriteLine("\t\t\tStart of Op3");
			Op4();
			Console.WriteLine("\t\t\tEnd of Op3");
		}
		private static void Op4() {
			Console.WriteLine("\t\t\t\tStart of Op4");
			Random r = new Random();
			int val = r.Next(30);
			if (val < 10) {
				throw new ArgumentException("BANG!");
			}
			else if (val < 20) {
				throw new ArithmeticException("BANG2!");
			}
			Console.WriteLine("\t\t\t\tEnd of Op4");
		}
	}
}