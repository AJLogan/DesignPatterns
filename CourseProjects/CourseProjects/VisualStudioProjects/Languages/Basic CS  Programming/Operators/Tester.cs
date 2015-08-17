using System;

namespace OperatorOverloading {
	class Tester {
		static void Main(string[] args){
			Point p1 = new Point(10,20);
			Point p2 = new Point(30,40);

			Console.WriteLine("p1 is {0}",p1);
			Console.WriteLine("p2 is {0}",p2);

			Point p3 = p1 + p2;
			Console.WriteLine("p3 is {0}",p3);

			p3++;
			Console.WriteLine("p3 incremented to {0}",p3);
			
			Point p4 = new Point(50,50);
			Point p5 = new Point(50,50);

			bool b1 = compareAsObjects(p4,p5);
			bool b2 = compareAsPoints(p4,p5);
			bool b3 = compareWithEquals(p4,p5);
			Console.WriteLine("Comparisons of p4 and p5 return {0} {1} {2}",b1,b2,b3);
		}
		private static bool compareAsObjects(object p1, object p2) {
			return p1 == p2;
		}
		private static bool compareAsPoints(Point p1, Point p2) {
			return p1 == p2;
		}
		private static bool compareWithEquals(Point p1, Point p2) {
			return p1.Equals(p2);
		}
	}
}
