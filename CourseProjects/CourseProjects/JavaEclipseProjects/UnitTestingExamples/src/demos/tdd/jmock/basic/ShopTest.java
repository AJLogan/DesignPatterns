package demos.tdd.jmock.basic;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
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
	public void makePurchaseWorksForValidQuantity() {
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
	public void makePurchaseFailsForInvalidQuantity() {
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
	private PricingEngine pricingEngine;
	private PaymentEngine paymentEngine;
	private StockCheckEngine stockCheckEngine;
	private Mockery mockery;
}
