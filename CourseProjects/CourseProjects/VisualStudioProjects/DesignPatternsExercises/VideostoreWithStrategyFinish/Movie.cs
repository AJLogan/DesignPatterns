using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithStrategyFinish {
    public enum PriceCode { CHILDRENS, REGULAR, NEW_RELEASE }

    public class Movie {
        public Movie(String title, PriceCode priceCode) {
            this.title = title;
            this.pricecode = priceCode;
        }
        public PriceCode PriceCode {
            get { return pricecode; }
            set { pricecode = value;  }
        }
        public string Title {
            get { return title; }
        }
        public double Cost(int daysRented) {
            double cost = 0;
            switch (pricecode) {
                case PriceCode.REGULAR:
                    cost += 2;
                    if (daysRented > 2)
                        cost += (daysRented - 2) * 1.5;
                    break;
                case PriceCode.NEW_RELEASE:
                    cost += daysRented * 3;
                    break;
                case PriceCode.CHILDRENS:
                    cost += 1.5;
                    if (daysRented > 3)
                        cost += (daysRented - 3) * 1.5;
                    break;
            }
            return cost;
        }
        public int Points(int daysRented) {
            int frequentRenterPoints = 1;
            // add bonus for a two day new release rental
            if ((pricecode == PriceCode.NEW_RELEASE) && daysRented > 1)
                frequentRenterPoints++;
            return frequentRenterPoints;
        }
        private string title;
        private PriceCode pricecode;
    }
}
