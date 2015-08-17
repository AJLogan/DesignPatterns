using System;

namespace OperatorOverloading {
	class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public static Point operator++(Point p) {
			p.x++;
			p.y++;
			return p;
		}
		public static Point operator+(Point p1, Point p2) {
			return new Point(p1.x + p2.x , p1.y + p2.y);
		}
		public static bool operator==(Point p1, Point p2) {
			return ((p1.x == p2.x) && (p1.y == p2.y));
		}
		public static bool operator!=(Point p1, Point p2) {
			return !(p1 == p2);
		}
		public override bool Equals(object obj) {
			return this == (Point)obj;
		}
		public override string ToString() {
			return "[" + x + "," + y + "]";
		}
		private int x;
		private int y;
	}
}
