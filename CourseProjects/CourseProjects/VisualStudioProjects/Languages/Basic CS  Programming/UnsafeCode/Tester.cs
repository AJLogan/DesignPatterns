using System;
using System.Text;

namespace UnsafeCode
{
	struct Point {
		public int X;
		public int Y;
		public override string ToString() {
			return "Point at coordinates " + X + " " + Y;
		}
	}
	class Tester {
		static void Main(string[] args) {
			showPointerSyntax();
			showArrowOperator();
			showFixedStatement();
		}
		private static unsafe void showFixedStatement() {
			string str = "ABCDEFGHIJKKLMNOPQRSTUVWXYZ";

			//The GC will not more str for the duration of useBuilder
			fixed(char * ptr = str) useString(ptr);

			Console.WriteLine(str);
		}
		private static unsafe void useString(char * s_ptr) {
			//Print out the string using pointer arithmetic
			for(int i=0; s_ptr[i] != '\0'; i++) {
				Console.Write(s_ptr[i]);
				
				//Modify the string just to see what happens
				// MAY CAUSE UNDEFINED BEHAVIOUR !!!
				s_ptr[i] = 'Z';
			}
			Console.WriteLine();
		}
		private static unsafe void showArrowOperator() {
			Point p;
			
			//Create a pointer to a struct
			Point * p_ptr = &p;

			//Initialie the struct through the pointer
			p_ptr->X = 20;
			p_ptr->Y = 50;

			//Call the ToString method via the pointer
			String msg = p_ptr->ToString();

			Console.WriteLine(msg);
			
		}
		private static unsafe void showPointerSyntax() {
			int myInt = 123;

			//declare a pointer to an int
			int * i_ptr;

			//make the pointer point to myInt
			i_ptr = &myInt;

			//print the address where myInt can be found
			// this is 1242776 on original machine
			uint address = (uint)i_ptr;
			Console.WriteLine("Address of int is: {0}", address);

			//print the value of myInt by dreferencing the pointer
			Console.WriteLine("Value of int is: {0}", *i_ptr);

			//make a second pointer point to the address of
			// myint on the stack NB 1242776 is compiler dependant
			// magic number which probably only works on original machine
			int * i_ptr2 = (int *)1242776;
			Console.WriteLine("Value of int is: {0}", *i_ptr2);
		}
		
	}
}
