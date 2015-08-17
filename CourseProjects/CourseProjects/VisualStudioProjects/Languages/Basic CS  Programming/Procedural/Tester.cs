using System;

namespace Procedural {
	class Tester {
		static void Main(string[] args) {
			Random r = new Random();

			showIfStatement(r);
			showSwitchStatement(r);
			showWhileLoop(r);
			showDoWhileLoop(r);
			showForLoop(r);
		}
		private static void showDoWhileLoop(Random r) {
			Console.WriteLine("----- Do While Loop -----");
			int val;
			do {
				val = r.Next(30);
				Console.WriteLine("\tIn do-while loop with value {0}",val);
			} while(val < 15);
		}
		private static void showWhileLoop(Random r) {
			Console.WriteLine("----- While Loop -----");
			int val = r.Next(30);
			while(val < 15) {
				Console.WriteLine("\tIn while loop with value {0}",val);
				val = r.Next(30);
			}
			Console.WriteLine("\tLeft while loop with value {0}",val);
		}
		private static void showForLoop(Random r) {
			Console.WriteLine("----- For Loop -----");
			int val = r.Next(10);
			for(int i=1;i<=val;i++) {
				Console.WriteLine("\tLoop {0} of {1}",i,val);
			}
		}
		private static void showSwitchStatement(Random r) {
			Console.WriteLine("----- Switch Statement For Int -----");
			int val = r.Next(4);
			switch(val){
				case 0:
					Console.WriteLine("\tValue is zero");
					break;
				case 1:
				case 2:
					Console.WriteLine("\tValue {0} is one or two",val);
					break;
				default:
					Console.WriteLine("\tValue must be three ({0})",val);
					break;
			}
			Console.WriteLine("----- Switch Statement For String -----");
			string valStr = r.Next(4).ToString();
			switch(valStr){
				case "0":
					Console.WriteLine("\tValue is zero");
					break;
				case "1":
				case "2":
					Console.WriteLine("\tValue {0} is one or two",valStr);
					break;
				default:
					Console.WriteLine("\tValue must be three ({0})",valStr);
					break;
			}
		}
		private static void showIfStatement(Random r) {
			Console.WriteLine("----- If Statement -----");
			int val = r.Next(30);
			if(val < 10) {
				Console.WriteLine("\t{0} is less than 10",val);
			} else if(val < 20) {
				Console.WriteLine("\t{0} is less than 20",val);
			} else {
				Console.WriteLine("\t{0} is less than 30",val);
			}
		}
	}
}





