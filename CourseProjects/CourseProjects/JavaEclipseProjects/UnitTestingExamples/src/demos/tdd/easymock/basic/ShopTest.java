package demos.tdd.easymock.basic;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShopTest {
	@Before
	public void start() {
		pricingEngine = createMock(PricingEngine.class);
		paymentEngine = createMock(PaymentEngine.class);
		stockCheckEngine = createMock(StockCheckEngine.class);
	}
	@Test
	public void makePurchaseWorksForValidQuantity() {
		expect(stockCheckEngine.check("AB12")).andReturn(20);
		expect(pricingEngine.price("AB12",19)).andReturn(27.30);
		expect(paymentEngine.authorize("010203XYZ",27.30)).andReturn(true);
		replayMocks();
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(s.makePurchase("AB12", 19, "010203XYZ"));
		verifyMocks();
	}
	@Test
	public void makePurchaseWorksForInvalidQuantity() {
		expect(stockCheckEngine.check("AB12")).andReturn(20);
		replayMocks();
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertFalse(s.makePurchase("AB12", 21, "010203XYZ"));
		verifyMocks();
	}
	private void verifyMocks() {
		verify(stockCheckEngine);
		verify(pricingEngine);
		verify(paymentEngine);
	}
	private void replayMocks() {
		replay(stockCheckEngine);
		replay(pricingEngine);
		replay(paymentEngine);
	}
	private PricingEngine pricingEngine;
	private PaymentEngine paymentEngine;
	private StockCheckEngine stockCheckEngine;
}
