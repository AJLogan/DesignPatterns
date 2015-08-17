using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BasicMocking {
    public interface IStockCheckEngine {
        int Check(String itemNo);
    }
    public interface IPricingEngine {
        double Price(String itemNo, int quantity);
    }
    public interface IPaymentEngine {
        bool Authorize(String cardNo, double amount);
    }
}
