using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace MockingChallengeFinish {

    [TestClass]
    public class TravelAllowanceCalculatorTest {
        [TestInitialize]
        public void Start() {
            calculator = new TravelAllowanceCalculator(null, null);
        }
        [TestMethod]
	    [Ignore]
        public void LocalFlightFirstClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
        public void LocalFlightBusinessClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.BUSINESS, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
        public void LocalFlightEconomyClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.ECONOMY, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
        public void InternationalFlightFirstClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
        public void InternationalFlightBusinessClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.BUSINESS, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
        public void InternationalFlightEconomyClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.ECONOMY, DateTime.Now);
            Assert.AreEqual(123, calculator.CalculateAllowance(f), 0.001);
        }
        [TestMethod]
	    [Ignore]
	    public void MultipleLocalFlights() {
            Flight f1 = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);
            Flight f2 = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);
            Assert.AreEqual(1285, calculator.CalculateAllowance(f1, f2), 0.001);
	    }
        [TestMethod]
        [Ignore]
	    //Multiple international flights should qualify for extra allowance
	    public void MultipleInternationalFlights() {
            Flight f1 = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);
            Flight f2 = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);
		    Flight f3 = new Flight("Heathrow","Dublin",Seating.FIRST,DateTime.Now);
		    Assert.AreEqual(123,calculator.CalculateAllowance(f1,f2,f3),0.001);
	    }
        private TravelAllowanceCalculator calculator;
    }
}
