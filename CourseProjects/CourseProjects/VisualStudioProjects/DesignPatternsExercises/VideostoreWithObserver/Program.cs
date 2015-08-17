using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithObserver {
    /*
     * This example adapted from 'Refactoring' by Martin Fowler 
     */

    public class Program {
        private static void Main(string[] args) {
            var peterPan = new Movie("Peter Pan", PriceCode.CHILDRENS);
            var theHulk = new Movie("The Hulk", PriceCode.REGULAR);
            var starWars = new Movie("Star Wars", PriceCode.REGULAR);
            var toyStory = new Movie("Toy Story", PriceCode.CHILDRENS);
            var killBill = new Movie("Kill Bill", PriceCode.NEW_RELEASE);

            var r1 = new Rental(peterPan, 2);
            var r2 = new Rental(theHulk, 1);
            var r3 = new Rental(starWars, 3);
            var r4 = new Rental(toyStory, 2);
            var r5 = new Rental(killBill, 4);

            var customer = new Customer("Joe Bloggs");
            customer.OnRentalAdd += delegate(Rental r) {
                                        Console.WriteLine("D: Rental added for " + r.Movie.Title);
                                    };
            customer.OnRentalAdd += (r) => Console.WriteLine("L: Rental added for " + r.Movie.Title);

            customer.AddRental(r1);
            customer.AddRental(r2);
            customer.AddRental(r3);
            customer.AddRental(r4);
            customer.AddRental(r5);

            Console.WriteLine(customer.Statement());
        }
    }
}