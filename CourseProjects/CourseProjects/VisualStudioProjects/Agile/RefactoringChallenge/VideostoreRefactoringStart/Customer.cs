using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreRefactoringStart {
    public class Customer {
        public Customer(String name) {
            this.name = name;
            rentals = new List<Rental>();
        }
        public String Name {
            get { return name; }
        }
        public void AddRental(Rental arg) {
            rentals.Add(arg);
        }
        public string Statement() {
            double totalAmount = 0;
            int frequentRenterPoints = 0;
            StringBuilder result = new StringBuilder();
            //add header lines
            result.Append("\nRental Record for ");
            result.Append(Name);
            result.Append("\n");
            foreach (Rental each in rentals) {
                double thisAmount = 0;
                //determine amounts for each line
                switch (each.Movie.PriceCode) {
                case PriceCode.REGULAR:
                    thisAmount += 2;
                    if (each.DaysRented > 2)
                        thisAmount += (each.DaysRented - 2) * 1.5;
                    break;
                case PriceCode.NEW_RELEASE:
                    thisAmount += each.DaysRented * 3;
                    break;
                case PriceCode.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.DaysRented > 3)
                        thisAmount += (each.DaysRented - 3) * 1.5;
                    break;
                }
                // add frequent renter points
                frequentRenterPoints++;
                // add bonus for a two day new release rental
                if ((each.Movie.PriceCode == PriceCode.NEW_RELEASE)
                        && each.DaysRented > 1)
                    frequentRenterPoints++;
                //show figures for this rental
                result.Append("\t");
                result.Append(each.DaysRented);
                result.Append("\t");
                result.Append(each.Movie.Title);
                result.Append("\t");
                result.Append(thisAmount);
                result.Append("\n");
                //add cost of this rental to total cost
                totalAmount += thisAmount;
            }
            //add footer lines
            result.Append("Amount owed is ");
            result.Append(totalAmount);
            result.Append("\n");
            result.Append("You earned ");
            result.Append(frequentRenterPoints);
            result.Append(" frequent renter points\n");
            return result.ToString();
        }
        private String name;
        private List<Rental> rentals;
    }
}
