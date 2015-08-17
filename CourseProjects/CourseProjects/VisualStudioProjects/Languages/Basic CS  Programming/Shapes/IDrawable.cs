using System;

namespace Interfaces {
	public interface IDrawable
	{
		void draw(int size);
		int X { get; set; }
		int Y { get; set; }
	}
}
