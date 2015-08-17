using System;

namespace Interfaces
{
	public class Square : Shape {
		public override void paint(int color) {}
		public override void draw(int size) {
			drawTopOrBottom(size);
			drawSides(size);
			drawTopOrBottom(size);
		}
		private void drawTopOrBottom(int size) {
			for(int i=0;i<size;i++) {
				Console.Write("+");
			}
			Console.WriteLine();
		}
		private void drawSides(int size) {
			for(int i=0;i<size;i++) {
				Console.Write("+");
				for(int x=2;x<size;x++) {
					Console.Write(" ");
				}
				Console.WriteLine("+");
			}
		}
	}
}
