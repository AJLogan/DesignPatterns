using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CommandPatternStart {
    internal class Program {
        public static void Main(string[] args) {
            var list = new List<String>();
            while (true) {
                PrintMenu();
                string choice = Console.ReadLine();
                if (choice.Equals("add")) {
                    Console.WriteLine("Enter a string to add");
                    string item = Console.ReadLine();
                    list.Add(item);
                } else if (choice.Equals("get")) {
                    Console.WriteLine("Enter an index");
                    int index = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Item at {0} is {1}\n", index, list[index]);
                } else if (choice.Equals("remove")) {
                    Console.WriteLine("Enter an index");
                    int index = Convert.ToInt32(Console.ReadLine());
                    list.RemoveAt(index);
                    Console.WriteLine("Item removed from position {0}\n", index);
                } else if (choice.Equals("print")) {
                    Console.WriteLine("Contents of list are: ");
                    foreach (var str in list) {
                        Console.WriteLine("\t" + str);
                    }
                } else if (choice.Equals("undo")) {
                    Console.WriteLine("NOT IMPLEMENTED YET!");
                } else if (choice.Equals("redo")) {
                    Console.WriteLine("NOT IMPLEMENTED YET!");
                } else if (choice.Equals("quit")) {
                    Console.WriteLine("Thanks for playing!");
                    break;
                }
            }
        }

        private static void PrintMenu() {
            Console.WriteLine("Choose an option:");
            Console.WriteLine("\t [add] a string to the list");
            Console.WriteLine("\t [get] a string at a specified position");
            Console.WriteLine("\t [remove] a string from a specified position");
            Console.WriteLine("\t [print] the current contents of the list");
            Console.WriteLine("\t [undo] the last command");
            Console.WriteLine("\t [redo] the last command");
            Console.WriteLine("\t [quit] the program");
            Console.WriteLine();
        }
    }
}