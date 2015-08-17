using System;

namespace Interfaces
{
	public abstract class Shape : IColorable {
		public abstract void paint(int color);
		public abstract void draw(int size);

		public int X {
			get { return xPosition; }
			set { xPosition = value; }
		}

		public int Y {
			get { return yPosition; }
			set { yPosition = value; }
		}

		private int xPosition;
		private int yPosition;
	}
}
