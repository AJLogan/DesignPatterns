package demos.tdd.easymock.advanced;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
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
	public void singlePurchaseWorksForValidQuantity() {
		expect(stockCheckEngine.check("AB12")).andReturn(20);
		expect(pricingEngine.price("AB12",19)).andReturn(27.30);
		expect(paymentEngine.authorize("010203XYZ",27.30)).andReturn(true);
		replayMocks();
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(s.makePurchase("AB12", 19, "010203XYZ"));
		verifyMocks();
	}
	@Test
	public void singlePurchaseWorksForInvalidQuantity() {
		expect(stockCheckEngine.check("AB12")).andReturn(20);
		replayMocks();
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertFalse(s.makePurchase("AB12", 21, "010203XYZ"));
		verifyMocks();
	}
	@Test
	public void orderPossibleWhenItemsInStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		expect(stockCheckEngine.check("AB12")).andReturn(14);
		expect(stockCheckEngine.check("CD34")).andReturn(36);
		expect(stockCheckEngine.check("EF56")).andReturn(58);
		replayMocks();
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertEquals(0,shop.checkIfOrderPossible(items).length);
		verifyMocks();
	}
	@Test
	public void orderNotPossibleWhenItemsOutOfStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		expect(stockCheckEngine.check("AB12")).andReturn(14);
		expect(stockCheckEngine.check("CD34")).andReturn(32);
		expect(stockCheckEngine.check("EF56")).andReturn(54);
		replayMocks();
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		String [] results = shop.checkIfOrderPossible(items);
		assertEquals(2,results.length);
		assertEquals("CD34",results[0]);
		assertEquals("EF56",results[1]);
		verifyMocks();
	}
	@Test
	public void makeMultiplePurchasesWorksForValidQuantities() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		expect(stockCheckEngine.check(isA(String.class))).andReturn(100).times(3);
		
		expect(pricingEngine.price("AB12",12)).andReturn(1.23);
		expect(pricingEngine.price("CD34",34)).andReturn(3.45);
		expect(pricingEngine.price("EF56",56)).andReturn(6.78);
		
		expect(paymentEngine.authorize("010203XYZ",11.46)).andReturn(true);
		replayMocks();
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(shop.makePurchases(items, "010203XYZ"));
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
