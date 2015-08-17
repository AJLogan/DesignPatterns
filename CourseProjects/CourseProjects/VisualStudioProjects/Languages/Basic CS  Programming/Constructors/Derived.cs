using System;

namespace Constructors {
	class Tester {
		static void Main(string[] args) {
			Derived c1 = new Derived();
			Console.WriteLine("First Object: \n{0}",c1);
			Console.WriteLine("\n----------------------------\n");
			Derived c2 = new Derived("abc");
			Console.WriteLine("Second Object: \n{0}",c2);
			Console.WriteLine("\n----------------------------\n");
			Derived c3 = new Derived("abc","def");
			Console.WriteLine("Third Object: \n{0}",c3);
			Console.WriteLine("\n----------------------------\n");
			Derived c4 = new Derived("abc","def","ghi");
			Console.WriteLine("Fourth Object: \n{0}",c4);
		}
	}
	class Base {

		//The default constructor is written by the compiler
		// if no other constructors are present in the class
		public Base() : base() {}

		//First line of constructor must call superclass
		// or another constructor (default call inserted)
		public Base(string p1) {
			baseFieldOne = p1;
		}

		//Fields
		protected string baseFieldOne;
	}

	class Derived : Base {

		//Calls Base();
		public Derived() : base() {}

		//Calls Base(string)
		public Derived(string p1) : base(p1) {}

		//Reuse existing constructors
		public Derived(string p1, string p2) : this(p1) {
			derivedFieldOne = p2;
		}

		//Reuse existing constructors
		public Derived(string p1, string p2, string p3) :this(p1,p2) {
			derivedFieldTwo = p3;
		}

		public override string ToString() {
			return "\tbaseFieldOne is: " + baseFieldOne
			+ "\n\tderivedFieldOne is: " + derivedFieldOne
			+ "\n\tderivedFieldTwo is: " + derivedFieldTwo;
		}

		//Fields
		string derivedFieldOne;
		string derivedFieldTwo;
	}
}
