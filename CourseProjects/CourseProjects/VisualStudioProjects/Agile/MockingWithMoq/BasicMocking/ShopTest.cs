using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace BasicMocking {
    [TestClass]
    public class ShopTest {
        [TestInitialize]
        public void start() {
            pricingMock = new Mock<IPricingEngine>();
            paymentMock = new Mock<IPaymentEngine>();
            stockCheckMock = new Mock<IStockCheckEngine>();
        }
        [TestMethod]
        public void MakePurchaseWorksForValidQuantity() {
            stockCheckMock.Setup(m => m.Check("AB12")).Returns(20).Verifiable();
            pricingMock.Setup(m => m.Price("AB12", 19)).Returns(27.30).Verifiable();
            paymentMock.Setup(m => m.Authorize("010203XYZ", 27.30)).Returns(true).Verifiable();

            Shop s = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            Assert.IsTrue(s.makePurchase("AB12", 19, "010203XYZ"));

            stockCheckMock.Verify();
            pricingMock.Verify();
            paymentMock.Verify();
        }
        [TestMethod]
        public void MakePurchaseWorksForInvalidQuantity() {
            stockCheckMock.Setup(m => m.Check("AB12")).Returns(20).Verifiable();

            Shop s = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            Assert.IsFalse(s.makePurchase("AB12", 21, "010203XYZ"));

            stockCheckMock.Verify();
        }
        private Mock<IPricingEngine> pricingMock;
        private Mock<IPaymentEngine> paymentMock;
        private Mock<IStockCheckEngine> stockCheckMock;
    }
}
