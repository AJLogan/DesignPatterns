using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace MockingChallengeFinish {

    [TestClass]
    public class TravelAllowanceCalculatorTest {
        [TestInitialize]
        public void Start() {
            concessionsEngine = new Mock<IFlightConcessionsEngine>();
            pathDatabase = new Mock<IFlightPathDatabase>();
            calculator = new TravelAllowanceCalculator(concessionsEngine.Object, pathDatabase.Object);
        }
        [TestMethod]
        public void LocalFlightFirstClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Belfast", "Dublin")).Returns(90);

            Assert.AreEqual(9.0, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 9.0),Times.Once());
        }
        [TestMethod]
        public void LocalFlightBusinessClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.BUSINESS, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Belfast", "Dublin")).Returns(90);

            Assert.AreEqual(27.0, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 27.0), Times.Once());
        }
        [TestMethod]
        public void LocalFlightEconomyClass() {
            Flight f = new Flight("Belfast", "Dublin", Seating.ECONOMY, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Belfast", "Dublin")).Returns(90);

            Assert.AreEqual(45.0, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 45.0), Times.Once());
        }
        [TestMethod]
        public void InternationalFlightFirstClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Heathrow", "Dublin")).Returns(350);

            Assert.AreEqual(70.0, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 70.0), Times.Once());
        }
        [TestMethod]
        public void InternationalFlightBusinessClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.BUSINESS, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Heathrow", "Dublin")).Returns(350);

            Assert.AreEqual(140.0, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 140.0), Times.Once());
        }
        [TestMethod]
        public void InternationalFlightEconomyClass() {
            Flight f = new Flight("Heathrow", "Dublin", Seating.ECONOMY, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Heathrow", "Dublin")).Returns(350);

            Assert.AreEqual(210, calculator.CalculateAllowance(f), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(1, 210.0), Times.Once());
        }
        [TestMethod]
	    public void MultipleLocalFlights() {
            Flight f1 = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);
            Flight f2 = new Flight("Belfast", "Dublin", Seating.FIRST, DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Belfast", "Dublin")).Returns(90);

            Assert.AreEqual(18, calculator.CalculateAllowance(f1, f2), 0.001);
            concessionsEngine.Verify(m => m.AdditionalBenefitApplies(2, 18.0), Times.Once());
	    }
        [TestMethod]
	    //Multiple international flights should qualify for extra allowance
	    public void MultipleInternationalFlights() {
            Flight f1 = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);
            Flight f2 = new Flight("Heathrow", "Dublin", Seating.FIRST, DateTime.Now);
		    Flight f3 = new Flight("Heathrow","Dublin",Seating.FIRST,DateTime.Now);

            pathDatabase.Setup(m => m.FindFlightPath("Heathrow", "Dublin")).Returns(350);
            concessionsEngine.Setup(m => m.AdditionalBenefitApplies(3, 210.0)).Returns(true);
            concessionsEngine.Setup(m => m.CalculateBenefit(3, 210.0)).Returns(25.0);

		    Assert.AreEqual(235.0,calculator.CalculateAllowance(f1,f2,f3),0.001);
            pathDatabase.Verify(m => m.FindFlightPath(It.IsAny<string>(), It.IsAny<string>()),Times.Exactly(3));
	    }
        private TravelAllowanceCalculator calculator;
        private Mock<IFlightConcessionsEngine> concessionsEngine;
        private Mock<IFlightPathDatabase> pathDatabase;
    }
}
