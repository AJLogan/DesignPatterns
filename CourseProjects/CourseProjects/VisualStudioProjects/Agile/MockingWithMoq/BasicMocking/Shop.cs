using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BasicMocking {
    public class Shop {
        public Shop(IPricingEngine pricingEngine,
                    IStockCheckEngine stockCheckEngine,
                    IPaymentEngine paymentEngine) {
            this.pricingEngine = pricingEngine;
            this.stockCheckEngine = stockCheckEngine;
            this.paymentEngine = paymentEngine;
        }
        public bool makePurchase(String itemNo, int quantity, String cardNo) {
            if (stockCheckEngine.Check(itemNo) >= quantity) {
                double charge = pricingEngine.Price(itemNo, quantity);
                if (paymentEngine.Authorize(cardNo, charge)) {
                    return true;
                }
            }
            return false;
        }
        private IPricingEngine pricingEngine;
        private IStockCheckEngine stockCheckEngine;
        private IPaymentEngine paymentEngine;
    }
 
}
