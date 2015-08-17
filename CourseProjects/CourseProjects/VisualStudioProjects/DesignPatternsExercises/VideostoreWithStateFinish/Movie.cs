using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreWithStateFinish {
    public enum PriceCode {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }

    public class Movie {
        public Movie(String title, PriceCode priceCode) {
            this.title = title;
            type = ChooseType(priceCode);
        }

        public void SwitchType(PriceCode newPriceCode) {
            type = ChooseType(newPriceCode);
        }

        private MovieType ChooseType(PriceCode priceCode) {
            switch (priceCode) {
                case PriceCode.CHILDRENS:
                    return new ChildrensMovieType();
                case PriceCode.NEW_RELEASE:
                    return new NewReleaseMovieType();
                case PriceCode.REGULAR:
                    return new RegularMovieType();
                default:
                    throw new InvalidOperationException("Unknown pricecode");
            }
        }

        public string Title {
            get { return title; }
        }

        public double Cost(int daysRented) {
            return type.Cost(daysRented);
        }

        public int Points(int daysRented) {
            int frequentRenterPoints = 1;
            if (type.EarnsExtraPoints) {
                frequentRenterPoints += type.ExtraPoints(daysRented);
            }
            return frequentRenterPoints;
        }

        private readonly string title;
        private MovieType type;
    }
}