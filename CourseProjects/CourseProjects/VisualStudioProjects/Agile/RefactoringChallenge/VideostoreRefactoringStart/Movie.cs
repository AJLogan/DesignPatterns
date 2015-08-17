using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VideostoreRefactoringStart {
    public enum PriceCode { CHILDRENS, REGULAR, NEW_RELEASE }

    public class Movie {
        public Movie(String title, PriceCode priceCode) {
            this.title = title;
            this.pricecode = priceCode;
        }
        public PriceCode PriceCode {
            get { return pricecode;  }
            set { pricecode = value; }
        }
        public string Title {
            get { return title;  }
        }
        private string title;
        private PriceCode pricecode;
    }
}
