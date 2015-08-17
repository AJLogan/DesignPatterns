using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ExtensionMethodsCS {
    public class TestOne {
        public string Op1() {
            return "ABC";
        }
    }
    public static class TestTwo {
        public static string Op2(this TestOne obj, string str) {
            return obj.Op1() + str;
        }
    }
    class Program {
        static void Main(string[] args) {
            TestOne t = new TestOne();
            Console.WriteLine(t.Op1());
            Console.WriteLine(t.Op2("DEF"));
        }
    }
}
