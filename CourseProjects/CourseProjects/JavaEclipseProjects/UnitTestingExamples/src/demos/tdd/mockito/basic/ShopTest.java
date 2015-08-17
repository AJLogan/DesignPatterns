package demos.tdd.mockito.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;

public class ShopTest {
	@Before
	public void start() {
		pricingEngine = mock(PricingEngine.class);
		paymentEngine = mock(PaymentEngine.class);
		stockCheckEngine = mock(StockCheckEngine.class);
	}
	@Test
	public void makePurchaseWorksForValidQuantity() {
		when(stockCheckEngine.check("AB12")).thenReturn(20);
		when(pricingEngine.price("AB12",19)).thenReturn(27.30);
		when(paymentEngine.authorize("010203XYZ",27.30)).thenReturn(true);
		
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(s.makePurchase("AB12", 19, "010203XYZ"));
		
		verify(stockCheckEngine).check("AB12");
		verify(pricingEngine).price("AB12",19);
		verify(paymentEngine).authorize("010203XYZ",27.30);
	}
	@Test
	public void makePurchaseWorksForInvalidQuantity() {
		when(stockCheckEngine.check("AB12")).thenReturn(20);

		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertFalse(s.makePurchase("AB12", 21, "010203XYZ"));

		verify(stockCheckEngine).check("AB12");
	}
	private PricingEngine pricingEngine;
	private PaymentEngine paymentEngine;
	private StockCheckEngine stockCheckEngine;
}
