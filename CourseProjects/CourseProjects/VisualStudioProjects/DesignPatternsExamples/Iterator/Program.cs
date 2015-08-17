using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Iterator
{
    class Program
    {
        static void Main(string[] args) {
            var myList = new LinkedList<string>();
            myList.Add("abc");
            myList.Add("def");
            myList.Add("ghi");
            myList.Add("jkl");
            myList.Add("mno");

            Console.WriteLine("List contents are:");
            foreach (string s in myList) {
                Console.WriteLine("\t" + s);
            }
        }
    }
}
