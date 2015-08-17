using System;
using System.Collections;

namespace CSharpIndexers {
	class Tester {
		static void Main(string[] args) {
		    demoIntIndexer();
		    demoStringIndexer();
		}
	    private static void demoStringIndexer() {
	        DemoTwo obj = new DemoTwo();
	        obj["k1"] = "abc";
	        obj["k2"] = "def";
	        obj["k3"] = "ghi";
	        obj["k4"] = "jkl";
	        Console.WriteLine("Values are {0}, {1}, {2} and {3}", obj["k1"], obj["k2"], obj["k3"], obj["k4"]);
	    }
	    private static void demoIntIndexer() {
	        DemoOne obj = new DemoOne(4);
	        obj[0] = 101;
	        obj[1] = 202;
	        obj[2] = 303;
	        obj[3] = 404;
	        Console.WriteLine("Values are {0}, {1}, {2} and {3}", obj[0], obj[1], obj[2], obj[3]);
	    }
	}

	public class DemoOne {
	    public DemoOne(int max) {
            items = new int[max];
	    }
		public int this[int index] {
            get { return items[index]; }
            set { items[index] = value; }
		}
		private int [] items;
	}
    public class DemoTwo
    {
        public DemoTwo()
        {
            items = new Hashtable();
        }
        public string this[string key]
        {
            get { return (string)items[key]; }
            set { items[key] = value; }
        }
        private Hashtable items;
    }
}