using System;

namespace Interfaces
{
	public class Triangle : Shape {
		public override void paint(int color) {}
		public override void draw(int size) {
			for(int i=0;i<size;i++) {
				printLeftSize(size,i);
				printMiddle(size,i);
				printRightSize();
			}
			printBase(size);
		}
		private void printLeftSize(int size,int rowNum) {
			for(int x=(size - rowNum);x>0;x--) {
				Console.Write(" ");
			}
			Console.Write("/");
		}
		private void printMiddle(int size,int rowNum) {
			for(int x=0;x<rowNum;x++) {
				Console.Write("  ");
			}
		}
		private void printRightSize() {
			Console.WriteLine(@"\");
		}
		private void printBase(int size) {
			int baseSize = size * 2;
			Console.Write(" ");
			for(int i=0;i<baseSize;i++) {
				Console.Write("-");
			}
			Console.WriteLine();
		}
	}
}
