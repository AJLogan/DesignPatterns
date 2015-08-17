package demos.tdd.jmock.advanced;

import static org.junit.Assert.*;

import java.util.SortedMap;
import java.util.TreeMap;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ShopTest {
	public ShopTest() {
		mockery = new JUnit4Mockery();
	}
	@Before
	public void start() {
		pricingEngine = mockery.mock(PricingEngine.class);
		paymentEngine = mockery.mock(PaymentEngine.class);
		stockCheckEngine = mockery.mock(StockCheckEngine.class);
	}
	@Test
	public void singlePurchaseWorksForValidQuantity() {
		mockery.checking(new Expectations() {{
								one(stockCheckEngine).check("AB12");
								will(returnValue(20));
							}});
		mockery.checking(new Expectations() {{
								one(pricingEngine).price("AB12",19);
								will(returnValue(27.30));
							}});
		mockery.checking(new Expectations() {{
								one(paymentEngine).authorize("010203XYZ",27.30);
								will(returnValue(true));
							}});
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(s.makePurchase("AB12", 19, "010203XYZ"));
	}
	@Test
	public void singlePurchaseFailsForInvalidQuantity() {
		mockery.checking(new Expectations() {{
								one(stockCheckEngine).check("AB12");
								will(returnValue(20));
							}});
		mockery.checking(new Expectations() {{
								never(pricingEngine).price("",0);
							}});
		mockery.checking(new Expectations() {{
								never(paymentEngine).authorize("",0);
							}});
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertFalse(s.makePurchase("AB12", 21, "010203XYZ"));
	}
	@Test
	public void orderPossibleWhenItemsInStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		final Sequence seq = mockery.sequence("stock_checks");
		mockery.checking(new Expectations() {{
								one(stockCheckEngine).check("AB12");
								will(returnValue(14)); //OK
								inSequence(seq);
								one(stockCheckEngine).check("CD34");
								will(returnValue(36)); //OK
								inSequence(seq);
								one(stockCheckEngine).check("EF56");
								will(returnValue(58)); //OK
								inSequence(seq);
							}});
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertEquals(0,shop.checkIfOrderPossible(items).length);
	}
	@Test
	public void orderNotPossibleWhenItemsOutOfStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		final Sequence seq = mockery.sequence("stock_checks");
		mockery.checking(new Expectations() {{
								one(stockCheckEngine).check("AB12");
								will(returnValue(14)); //OK
								inSequence(seq);
								one(stockCheckEngine).check("CD34");
								will(returnValue(32)); //too low!
								inSequence(seq);
								one(stockCheckEngine).check("EF56");
								will(returnValue(54)); //too low!
								inSequence(seq);
							}});
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		String [] results = shop.checkIfOrderPossible(items);
		assertEquals(2,results.length);
		assertEquals("CD34",results[0]);
		assertEquals("EF56",results[1]);
	}
	@Test
	public void makeMultiplePurchasesWorksForValidQuantities() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		mockery.checking(new Expectations() {{
								exactly(3).of(stockCheckEngine).check(with(any(String.class)));
								will(returnValue(100)); //big enough for all items
							}});
		final Sequence seq = mockery.sequence("pricings");
		mockery.checking(new Expectations() {{
								one(pricingEngine).price("AB12",12);
								will(returnValue(1.23));
								inSequence(seq);
								one(pricingEngine).price("CD34",34);
								will(returnValue(3.45));
								inSequence(seq);
								one(pricingEngine).price("EF56",56);
								will(returnValue(6.78));
								inSequence(seq);
							}});
		mockery.checking(new Expectations() {{
								one(paymentEngine).authorize("010203XYZ",11.46);
								will(returnValue(true));
							}});
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(shop.makePurchases(items, "010203XYZ"));
	}
	private PricingEngine pricingEngine;
	private PaymentEngine paymentEngine;
	private StockCheckEngine stockCheckEngine;
	private Mockery mockery;
}
