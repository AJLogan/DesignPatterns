package patterns.cake

trait PricingEngine {
  def price(productId: String, quantity: Int): Double
}

trait PaymentsEngine {
  def makePayment(cardNumber: String, amount: Double): Boolean
}

trait StockCheckEngine {
  def quantityInStock(productId: String): Int
}

trait PricingEngineComponent {
  val pricingEngine: PricingEngine

  class PricingEngineStub extends PricingEngine {
    def price(productId: String, quantity: Int) = {
      println("Stub pricing engine called")
      4.50
    }
  }

  class PricingEngineReal extends PricingEngine {
    def price(productId: String, quantity: Int) = {
      println("Real pricing engine called")
      5.60
    }
  }

}

trait PaymentsEngineComponent {
  val paymentsEngine: PaymentsEngine

  class PaymentsEngineStub extends PaymentsEngine {
    def makePayment(cardNumber: String, amount: Double) = {
      println("Stub payments engine called")
      true
    }
  }

  class PaymentsEngineReal extends PaymentsEngine {
    def makePayment(cardNumber: String, amount: Double) = {
      println("Real payments engine called")
      true
    }
  }

}

trait StockCheckEngineComponent {
  val stockCheckEngine: StockCheckEngine

  class StockCheckEngineStub extends StockCheckEngine {
    def quantityInStock(productId: String) = {
      println("Stub stock check engine called")
      12
    }
  }

  class StockCheckEngineReal extends StockCheckEngine {
    def quantityInStock(productId: String) = {
      println("Real stock check engine called")
      24
    }
  }

}

trait ShopComponent {
  this: PricingEngineComponent with PaymentsEngineComponent with StockCheckEngineComponent =>

  val shop = new Shop

  class Shop {
    def makePurchase(productId: String, quantity: Int, cardNumber: String): Boolean = {
      if (stockCheckEngine.quantityInStock(productId) >= quantity) {
        val price = pricingEngine.price(productId, quantity)
        paymentsEngine.makePayment(cardNumber, price)
      }
      false
    }
  }
}

object UnitTestComponentRepository extends ShopComponent
                                   with PricingEngineComponent
                                   with PaymentsEngineComponent
                                   with StockCheckEngineComponent {
  val pricingEngine = new PricingEngineStub
  val paymentsEngine = new PaymentsEngineStub
  val stockCheckEngine = new StockCheckEngineStub
}

object IntegrationTestComponentRepository extends ShopComponent
                                          with PricingEngineComponent
                                          with PaymentsEngineComponent
                                          with StockCheckEngineComponent {
  val pricingEngine = new PricingEngineReal
  val paymentsEngine = new PaymentsEngineReal
  val stockCheckEngine = new StockCheckEngineStub
}

object ProductionComponentRepository extends ShopComponent
                                     with PricingEngineComponent
                                     with PaymentsEngineComponent
                                     with StockCheckEngineComponent {
  val pricingEngine = new PricingEngineReal
  val paymentsEngine = new PaymentsEngineReal
  val stockCheckEngine = new StockCheckEngineReal
}

object Program {
  def main(args : Array[String]) {
    println("----- Making Purchase Using Unit Test Repository -----")
    val shopWithStubs = UnitTestComponentRepository.shop
    shopWithStubs.makePurchase("AB12", 8, "XYZ987FGR6")

    println("----- Making Purchase Using Integration Test Repository -----")
    val shopWithSomeStubs = IntegrationTestComponentRepository.shop
    shopWithSomeStubs.makePurchase("AB12", 8, "XYZ987FGR6")

    println("----- Making Purchase Using Production Repository -----")
    val shopWithImpls = ProductionComponentRepository.shop
    shopWithImpls.makePurchase("AB12", 8, "XYZ987FGR6")
  }
}
