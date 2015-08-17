using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithStrategyFinish {
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
        private double TotalCost() {
		    double totalAmount = 0;
		    foreach(Rental rental in rentals) {
			    totalAmount += rental.Cost();
		    }
		    return totalAmount;
	    }
        private int TotalPoints() {
		    int points = 0;
		    foreach(Rental rental in rentals) {
			    points += rental.Points();
		    }
		    return points;
	    }
        public String Statement(Strategy strategy) {
		    var result = new StringBuilder();
            result.Append(strategy.Preamble);
            var header = string.Format("Rental Record for {0}",Name);	   
		    result.Append(strategy.FormatHeader(header));
		    foreach(Rental rental in rentals) {
			    // show figures for this rental
		        var rentalLine = string.Format("\t{0}\t{1}\t{2}",
                                               rental.DaysRented,
                                               rental.Movie.Title,
                                               rental.Cost());
			    result.Append(strategy.FormatRentalLine(rentalLine));
		    }
		    // add footer lines
            var footer = new StringBuilder();
            footer.Append("Amount owed is ");
            footer.Append(TotalCost());
            footer.Append(". You earned ");
            footer.Append(TotalPoints());
            footer.Append(" frequent renter points");
            result.Append(strategy.FormatFooter(footer.ToString()));
            result.Append(strategy.Postscript);
		    return result.ToString();
	    }
        private String name;
        private List<Rental> rentals;
    }
}
