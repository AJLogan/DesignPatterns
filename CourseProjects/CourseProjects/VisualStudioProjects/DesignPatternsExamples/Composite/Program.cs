using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite {
    internal class Program {
        private static void Main(string[] args) {
            var n = BuildFileSystem();
            Console.WriteLine("Total size is: " + n.Length);
            n.Print();
        }

        private static Node BuildFileSystem() {
            var d1 = new Directory("C");
            var d2 = new Directory("usr");
            var d3 = new Directory("bin");
            var d4 = new Directory("dave");
            var d5 = new Directory("fred");
            var d6 = new Directory("java");

            d1.Add(d2);
            d1.Add(d3);
            d2.Add(d4);
            d2.Add(d5);
            d3.Add(d6);
            d3.Add(new File("vi.exe", 2000));
            d3.Add(new File("emacs.exe", 5000));
            d4.Add(new File("a.txt", 20));
            d4.Add(new File("b.txt", 30));
            d5.Add(new File("c.txt", 50));
            d6.Add(new File("java.exe", 8000));
            d6.Add(new File("javac.exe", 6000));

            return d1;
        }
    }
}