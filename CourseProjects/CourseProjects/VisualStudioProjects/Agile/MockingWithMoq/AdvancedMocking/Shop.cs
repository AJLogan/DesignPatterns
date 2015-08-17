using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AdvancedMocking {
    public enum PurchaseResults { SUCCESS, ITEMS_OUT_OF_STOCK, AUTHORIZATION_FAILURE, CARD_INVALID }

    public class Shop {
        public Shop(IPricingEngine pricingEngine, 
                    IStockCheckEngine stockCheckEngine, 
                    IPaymentEngine paymentEngine) {
		    this.pricingEngine = pricingEngine;
		    this.stockCheckEngine = stockCheckEngine;
		    this.paymentEngine = paymentEngine;
	    }
	    public bool MakePurchase(String itemNo, int quantity, String cardNo) {
		    if(stockCheckEngine.Check(itemNo) >= quantity) {
			    double charge = pricingEngine.Price(itemNo, quantity);
			    if(paymentEngine.Authorize(cardNo, charge)) {
				    return true;
			    }
		    }
		    return false;
	    }
	    public Dictionary<string,int> CheckForUnderstockedItems(SortedDictionary<string,int> items) {
            var itemsUnderstocked = new Dictionary<string, int>();
		    foreach(var entry in items) {
                int numAvailable = stockCheckEngine.Check(entry.Key);
			    if(numAvailable < entry.Value) {
                    itemsUnderstocked.Add(entry.Key, entry.Value - numAvailable);
			    }
		    }
		    return itemsUnderstocked;
	    }
        public PurchaseResults MakePurchases(SortedDictionary<string, int> items, string cardNo) {
		    var understocked = CheckForUnderstockedItems(items);
		    if(understocked.Count == 0) {
			    double charge = 0;
                foreach (var entry in items) {
				    charge += pricingEngine.Price(entry.Key, entry.Value);
			    }
                try {
                    if (paymentEngine.Authorize(cardNo, charge)) {
                        return PurchaseResults.SUCCESS;
                    } else {
                        return PurchaseResults.AUTHORIZATION_FAILURE;
                    }
                } catch(InvalidCardException) {
                    return PurchaseResults.CARD_INVALID;
                }
		    } else {
                return PurchaseResults.ITEMS_OUT_OF_STOCK;
		    }
	    }

        private IPricingEngine pricingEngine;
        private IStockCheckEngine stockCheckEngine;
        private IPaymentEngine paymentEngine;
    }
}
