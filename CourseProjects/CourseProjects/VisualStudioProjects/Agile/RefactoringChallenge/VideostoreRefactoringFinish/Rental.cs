using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreRefactoringFinish {
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
        public double Cost() {
            return movie.Cost(daysRented);
        }
        public int Points() {
            return movie.Points(daysRented);
        }
        private Movie movie;
        private int daysRented;
    }
}
