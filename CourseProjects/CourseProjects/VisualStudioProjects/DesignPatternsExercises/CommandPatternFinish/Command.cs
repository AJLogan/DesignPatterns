using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CommandPatternFinish {
    internal abstract class Command {
        protected Command(List<string> list) {
            this.list = list;
        }
        public abstract void Undo();
        public abstract void Redo();
        public abstract bool Execute();
        protected List<string> list;
    }

    internal class AddCommand : Command {
        internal AddCommand(List<string> list) : base(list) { }
        public override void Undo() {
            list.RemoveAt(list.Count - 1);
        }
        public override void Redo() {
            list.Add(list[list.Count - 1]);
        }
        public override bool Execute() {
            Console.WriteLine("Enter a string to add");
            list.Add(Console.ReadLine());
		    return true;
        }
    }

    internal class GetCommand : Command {
        internal GetCommand(List<string> list) : base(list) { }

        public override void Undo() {
            Console.WriteLine("Sorry - get cannot be undone!");
        }
        public override void Redo() {
            Console.WriteLine("Item at {0} is {1}\n", index, list[index]);
        }
        public override bool Execute() {
		    Console.WriteLine("Enter an index");
		    index = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Item at {0} is {1}\n", index, list[index]);
		    return true;
        }
        private int index;
    }

    internal class RemoveCommand : Command {
        internal RemoveCommand(List<string> list) : base(list) { }

        public override void Undo() {
            list.Insert(index,item);
        }

        public override void Redo() {
            list.RemoveAt(index);
            Console.WriteLine("Removed item at position {0}\n", index);
        }

        public override bool Execute() {
            Console.WriteLine("Enter an index");
            index = Convert.ToInt32(Console.ReadLine());
            item = list[index];
            list.RemoveAt(index);
            Console.WriteLine("Removed item at position {0}\n", index);
            return true;
        }

        private int index;
        private string item;
    }

    internal class PrintCommand : Command {
        internal PrintCommand(List<string> list) : base(list) { }

        public override void Undo() {
            Console.WriteLine("Sorry - print cannot be undone!");
        }

        public override void Redo() {
            Execute();
        }

        public override bool Execute() {
            Console.WriteLine("Contents of list are: ");
		    foreach(string str in list) {
                Console.WriteLine("\t" + str); 
		    }
		    return true;
        }
    }

    internal class QuitCommand : Command {
        internal QuitCommand(List<string> list) : base(list) { }

        public override void Undo() {
            throw new InvalidOperationException();
        }

        public override void Redo() {
            throw new InvalidOperationException();
        }

        public override bool Execute() {
            Console.WriteLine("Thanks for playing!");
		    return false;
        }
    }
}