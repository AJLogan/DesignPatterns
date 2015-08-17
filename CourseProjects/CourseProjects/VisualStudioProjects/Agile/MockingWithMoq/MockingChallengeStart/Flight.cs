using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MockingChallengeFinish {
    public enum Seating { FIRST, BUSINESS, ECONOMY }

    public class Flight {
        public Flight(string originAirport, string destinationAirport, Seating seating, DateTime date) {
            this.originAirport = originAirport;
            this.destinationAirport = destinationAirport;
            this.seating = seating;
            this.date = date;
        }
        public string Origin {
            get { return originAirport; }
        }
        public string Destination {
            get { return destinationAirport; }
        }
        public Seating Seating {
            get { return seating; }
        }
        public DateTime Date {
            get { return date; }
        }
        private String originAirport;
        private String destinationAirport;
        private Seating seating;
        private DateTime date;
    }
}
