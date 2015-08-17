using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace AdvancedMocking {
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
            Assert.IsTrue(s.MakePurchase("AB12", 19, "010203XYZ"));

            stockCheckMock.Verify();
            pricingMock.Verify();
            paymentMock.Verify();
        }
        [TestMethod]
        public void MakePurchaseWorksForInvalidQuantity() {
            stockCheckMock.Setup(m => m.Check("AB12")).Returns(20).Verifiable();

            Shop s = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            Assert.IsFalse(s.MakePurchase("AB12", 21, "010203XYZ"));

            stockCheckMock.Verify();
        }
        [TestMethod]
        public void OrderPossibleWhenItemsInStock() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            stockCheckMock.Setup(m => m.Check(It.IsAny<string>())).Returns(100);

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);

            Assert.AreEqual(0, shop.CheckForUnderstockedItems(items).Count);
            stockCheckMock.Verify(m => m.Check(It.IsAny<string>()), Times.Exactly(3));
        }
        [TestMethod]
        public void OrderNotPossibleWhenSomeItemsOutOfStock() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            stockCheckMock.Setup(m => m.Check("AB12")).Returns(14);
            stockCheckMock.Setup(m => m.Check("CD34")).Returns(31);
            stockCheckMock.Setup(m => m.Check("EF56")).Returns(50);

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            var results = shop.CheckForUnderstockedItems(items);

            stockCheckMock.Verify(m => m.Check(It.IsAny<string>()), Times.Exactly(3));
            Assert.AreEqual(2, results.Count);
            Assert.AreEqual(3, results["CD34"]);
            Assert.AreEqual(6, results["EF56"]);
        }
        [TestMethod]
        public void OrderNotPossibleWhenAllItemsOutOfStock() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            int count = 10;

            stockCheckMock.Setup(m => m.Check(It.IsAny<string>())).Returns((string s) => count++);

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            var results = shop.CheckForUnderstockedItems(items);

            Assert.AreEqual(3, results.Count);
            Assert.AreEqual(2, results["AB12"]);
            Assert.AreEqual(23, results["CD34"]);
            Assert.AreEqual(44, results["EF56"]);
        }
        [TestMethod]
	    public void MakeMultiplePurchasesWorksForValidQuantities() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            stockCheckMock.Setup(m => m.Check(It.IsAny<string>())).Returns(100);

            pricingMock.Setup(m => m.Price("AB12", 12)).Returns(1.23);
            pricingMock.Setup(m => m.Price("CD34", 34)).Returns(3.45);
            pricingMock.Setup(m => m.Price("EF56", 56)).Returns(6.78);

            paymentMock.Setup(m => m.Authorize("010203XYZ", 11.46)).Returns(true).Verifiable();

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
		    Assert.AreEqual(PurchaseResults.SUCCESS,shop.MakePurchases(items, "010203XYZ"));

            stockCheckMock.Verify(m => m.Check(It.IsAny<string>()), Times.Exactly(3));
            pricingMock.Verify(m => m.Price(It.IsAny<string>(), It.IsAny<int>()),Times.Exactly(3));
            paymentMock.Verify();
	    }
        [TestMethod]
        public void MakeMultiplePurchasesFailsForInvalidQuantities() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            stockCheckMock.Setup(m => m.Check(It.IsAny<string>())).Returns(1);

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            Assert.AreEqual(PurchaseResults.ITEMS_OUT_OF_STOCK, shop.MakePurchases(items, "010203XYZ"));

            stockCheckMock.Verify(m => m.Check(It.IsAny<string>()), Times.Exactly(3));
            pricingMock.Verify(m => m.Price(It.IsAny<string>(), It.IsAny<int>()), Times.Never());
            paymentMock.Verify(m => m.Authorize(It.IsAny<string>(), It.IsAny<double>()), Times.Never());
        }
        [TestMethod]
        public void MakeMultiplePurchasesFailsWhenCardInvalid() {
            var items = new SortedDictionary<string, int>();
            items.Add("AB12", 12);
            items.Add("CD34", 34);
            items.Add("EF56", 56);

            stockCheckMock.Setup(m => m.Check(It.IsAny<string>())).Returns(100);
            pricingMock.Setup(m => m.Price(It.IsAny<string>(), It.IsAny<int>())).Returns(2.0);
            paymentMock.Setup(m => m.Authorize("010203XYZ", 6.0)).Throws(new InvalidCardException());

            Shop shop = new Shop(pricingMock.Object, stockCheckMock.Object, paymentMock.Object);
            Assert.AreEqual(PurchaseResults.CARD_INVALID, shop.MakePurchases(items, "010203XYZ"));
        }
        private Mock<IPricingEngine> pricingMock;
        private Mock<IPaymentEngine> paymentMock;
        private Mock<IStockCheckEngine> stockCheckMock;
    }
}
