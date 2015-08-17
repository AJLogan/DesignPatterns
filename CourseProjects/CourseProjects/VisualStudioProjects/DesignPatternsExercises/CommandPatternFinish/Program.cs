using System;
using System.Collections.Generic;

namespace CommandPatternFinish {
    internal class Program {
        public static void Main(string[] args) {
            var list = new List<string>();
            var commands = CreateCommandsMap(list);
            Command command = null;
            while (true) {
                PrintMenu();
                var choice = Console.ReadLine();
                if (choice.Equals("undo")) {
                    if (command != null) {
                        command.Undo();
                    } else {
                        Console.WriteLine("Nothing to undo");
                    }
                } else if (choice.Equals("redo")) {
                    if (command != null) {
                        command.Redo();
                    } else {
                        Console.WriteLine("Nothing to redo");
                    }
                } else {
                    command = commands[choice];
                    if (command == null) {
                        Console.WriteLine("No such command!");
                    } else if (!command.Execute()) {
                        return;
                    }
                }

            }
        }

        private static Dictionary<string, Command> CreateCommandsMap(List<string> list) {
            var map = new Dictionary<string, Command> {
                {"add", new AddCommand(list)},
                {"get", new GetCommand(list)},
                {"remove", new RemoveCommand(list)},
                {"print", new PrintCommand(list)},
                {"quit", new QuitCommand(list)}
            };
            return map;
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