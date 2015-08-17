using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observer
{
    class Program
    {
        static void Main(string[] args) {
            var cart = new ShoppingCart();
            cart.AddObserver(new ObserverA());
            cart.AddObserver(new ObserverB());
            cart.AddObserver(new ObserverC());
            while (true) {
                Console.WriteLine("Enter an item for the cart or 'X' to end");
                var input = Console.ReadLine();
                if (input.Equals("X")) {
                    Console.WriteLine("Bye...");
                    return;
                } else {
                    cart.AddItem(input);
                }
            }
        }
    }
}
