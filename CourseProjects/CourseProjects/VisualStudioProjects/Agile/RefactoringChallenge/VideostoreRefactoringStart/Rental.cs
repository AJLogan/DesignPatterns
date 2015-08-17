using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreRefactoringStart {
    public class Rental {
        public Rental(Movie movie, int daysRented) {
            this.movie = movie;
            this.daysRented = daysRented;
        }
        public int DaysRented {
            get { return daysRented; }
        }
        public Movie Movie {
            get { return movie; }
        }
        private Movie movie;
        private int daysRented;
    }
}
