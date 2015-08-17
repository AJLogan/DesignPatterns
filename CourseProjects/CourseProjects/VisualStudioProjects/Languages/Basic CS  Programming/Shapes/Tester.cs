using System;

namespace Interfaces
{
	class Tester {
		
		static void Main(string[] args) {
			Triangle t = new Triangle();
			Square s = new Square();

			testColorable(t);
			testColorable(s);
		}
		private static void testColorable(IColorable ic) {
			ic.X = 25;
			ic.Y = 25;
			ic.draw(10);
			ic.paint(255);
		}
	}
}
