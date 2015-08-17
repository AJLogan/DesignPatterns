using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RomanNumeralsFinish {
    class RomanNumeral {
        public RomanNumeral(int decimalValue, string stringValue) {
            this.decimalValue = decimalValue;
            this.stringValue = stringValue;
        }
        public int DecimalValue {
            get { return decimalValue; }
        }
        public string StringValue {
            get { return stringValue; }
        }
        private readonly int decimalValue;
        private readonly string stringValue;
    }
}
