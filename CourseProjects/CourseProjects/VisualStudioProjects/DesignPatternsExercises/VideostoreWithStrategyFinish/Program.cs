using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithStrategyFinish {
    /*
     * This example adapted from 'Refactoring' by Martin Fowler 
     */
    public class Program {
        static void Main(string[] args) {
            Movie peterPan = new Movie("Peter Pan", PriceCode.CHILDRENS);
            Movie theHulk = new Movie("The Hulk", PriceCode.REGULAR);
            Movie starWars = new Movie("Star Wars", PriceCode.REGULAR);
            Movie toyStory = new Movie("Toy Story", PriceCode.CHILDRENS);
            Movie killBill = new Movie("Kill Bill", PriceCode.NEW_RELEASE);

            Rental r1 = new Rental(peterPan, 2);
            Rental r2 = new Rental(theHulk, 1);
            Rental r3 = new Rental(starWars, 3);
            Rental r4 = new Rental(toyStory, 2);
            Rental r5 = new Rental(killBill, 4);

            Customer customer = new Customer("Joe Bloggs");
            customer.AddRental(r1);
            customer.AddRental(r2);
            customer.AddRental(r3);
            customer.AddRental(r4);
            customer.AddRental(r5);

            Strategy strategy1 = new HtmlStrategy();
            Strategy strategy2 = new XmlStrategy();

            Console.WriteLine(customer.Statement(strategy1));
            Console.WriteLine(customer.Statement(strategy2));
        }
    }
}
