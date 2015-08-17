using System;

namespace CSharpPolymorphism {
	class Tester {
		static void Main(string[] args) {
			Base b1 = new Base();
			Base b2 = new Middle();
			Base b3 = new Derived();

			b1.func(); //calls Base.func
			b2.func(); //calls Middle.func
			b3.func(); //calls Middle.func

			//perform safe downcast using as
			Derived d = b3 as Derived;
			if (d != null) {
				d.func();	//calls Derived.func
			}

			//perform safe downcast using is
			if(b3 is Derived) {
				Derived tmp = (Derived)b3;
				tmp.func();	//calls Derived.func
			}
		}
	}
	class Base {
		//switch on polymorphism
		public virtual void func() {
			Console.WriteLine("Base.func called\n");
		}
	}
	class Middle : Base {
		//override base class implementation
		public override void func() {
			Console.WriteLine("Middle.func called\n");
		}
	}
	class Derived : Middle {
		//hide base class implementation
		public new void func() {
			Console.WriteLine("Derived.func called\n");
		}
	}
}
