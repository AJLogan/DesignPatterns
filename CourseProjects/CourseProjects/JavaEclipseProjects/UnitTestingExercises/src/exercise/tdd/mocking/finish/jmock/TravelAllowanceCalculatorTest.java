package exercise.tdd.mocking.finish.jmock;

import static org.junit.Assert.*;
import static exercise.tdd.mocking.finish.jmock.Seating.*;
import java.util.Date;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TravelAllowanceCalculatorTest {
	public TravelAllowanceCalculatorTest() {
		mockery = new JUnit4Mockery();
	}
	@Before
	public void start() {
		concessionsEngine = mockery.mock(FlightConcessionsEngine.class);
		pathDatabase = mockery.mock(FlightPathDatabase.class);
		calculator = new TravelAllowanceCalculator(concessionsEngine,pathDatabase);
	}
	@Test
    public void localFlightFirstClass() {
        Flight f = new Flight("Belfast","Dublin",FIRST,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Belfast", "Dublin");
								will(returnValue(90L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 9.0);
								will(returnValue(false));
							}});
        assertEquals(9.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void localFlightBusinessClass() {
        Flight f = new Flight("Belfast","Dublin",BUSINESS,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Belfast", "Dublin");
								will(returnValue(90L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 27.0);
								will(returnValue(false));
							}});
        assertEquals(27.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void localFlightEconomyClass() {
        Flight f = new Flight("Belfast","Dublin",ECONOMY,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Belfast", "Dublin");
								will(returnValue(90L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 45.0);
								will(returnValue(false));
							}});
        assertEquals(45.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightFirstClass() {
        Flight f = new Flight("Heathrow","Dublin",FIRST,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Heathrow", "Dublin");
								will(returnValue(350L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 70.0);
								will(returnValue(false));
							}});
        assertEquals(70.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightBusinessClass() {
        Flight f = new Flight("Heathrow","Dublin",BUSINESS,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Heathrow", "Dublin");
								will(returnValue(350L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 140.0);
								will(returnValue(false));
							}});
        assertEquals(140.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightEconomyClass() {
        Flight f = new Flight("Heathrow","Dublin",ECONOMY,new Date());
        mockery.checking(new Expectations() {{
								one(pathDatabase).findFlightPath("Heathrow", "Dublin");
								will(returnValue(350L));
							}});
        mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(1, 210.0);
								will(returnValue(false));
							}});
        assertEquals(210,calculator.calculateAllowance(f),0.001);
    }
	@Test
	public void multipleLocalFlights() {
		Flight f1 = new Flight("Belfast","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Belfast","Dublin",FIRST,new Date());
		mockery.checking(new Expectations() {{
								exactly(2).of(pathDatabase).findFlightPath("Belfast", "Dublin");
								will(returnValue(90L));
							}});
		mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(2, 18.0);
								will(returnValue(false));
							}});
		assertEquals(18.0,calculator.calculateAllowance(f1,f2),0.001);
	}
	@Test
	public void multipleInternationalFlights() {
		Flight f1 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f3 = new Flight("Heathrow","Dublin",FIRST,new Date());
		mockery.checking(new Expectations() {{
								exactly(3).of(pathDatabase).findFlightPath("Heathrow", "Dublin");
								will(returnValue(350L));
							}});
		mockery.checking(new Expectations() {{
								one(concessionsEngine).additionalBenefitApplies(3, 210.0);
								will(returnValue(true));
								one(concessionsEngine).calculateBenefit(3, 210.0);
								will(returnValue(25.0));
							}});
		assertEquals(235.0,calculator.calculateAllowance(f1,f2,f3),0.001);
	}
	private TravelAllowanceCalculator calculator;
	private FlightConcessionsEngine concessionsEngine;
	private FlightPathDatabase pathDatabase;
	private Mockery mockery;
}
