using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithObserver {
    public delegate void RentalAddedCallback(Rental r);

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
            if (OnRentalAdd != null) {
                OnRentalAdd(arg);
            }
        }

        private double TotalCost() {
            double totalAmount = 0;
            foreach (var rental in rentals) {
                totalAmount += rental.Cost();
            }
            return totalAmount;
        }

        private int TotalPoints() {
            int points = 0;
            foreach (var rental in rentals) {
                points += rental.Points();
            }
            return points;
        }

        public String Statement() {
            var result = new StringBuilder();
            // add header lines
            result.Append("\nRental Record for ");
            result.Append(Name);
            result.Append("\n");
            foreach (var rental in rentals) {
                // show figures for this rental
                result.Append("\t");
                result.Append(rental.DaysRented);
                result.Append("\t");
                result.Append(rental.Movie.Title);
                result.Append("\t");
                result.Append(rental.Cost());
                result.Append("\n");
            }
            // add footer lines
            result.Append("Amount owed is ");
            result.Append(TotalCost());
            result.Append("\n");
            result.Append("You earned ");
            result.Append(TotalPoints());
            result.Append(" frequent renter points\n");
            return result.ToString();
        }

        public event RentalAddedCallback OnRentalAdd;
        private readonly String name;
        private readonly List<Rental> rentals;
    }
}