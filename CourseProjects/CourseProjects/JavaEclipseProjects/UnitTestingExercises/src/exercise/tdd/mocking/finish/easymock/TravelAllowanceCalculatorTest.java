package exercise.tdd.mocking.finish.easymock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;
import static exercise.tdd.mocking.finish.easymock.Seating.*;
import java.util.Date;

import org.junit.*;

public class TravelAllowanceCalculatorTest {
	@Before
	public void start() {
		concessionsEngine = createMock(FlightConcessionsEngine.class);
		pathDatabase = createMock(FlightPathDatabase.class);
		calculator = new TravelAllowanceCalculator(concessionsEngine,pathDatabase);
	}
	@Test
    public void localFlightFirstClass() {
        Flight f = new Flight("Belfast","Dublin",FIRST,new Date());
        expect(pathDatabase.findFlightPath("Belfast","Dublin")).andReturn(90L);
        expect(concessionsEngine.additionalBenefitApplies(1, 9.0)).andReturn(false);
        replayMocks();
        assertEquals(9.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
    public void localFlightBusinessClass() {
        Flight f = new Flight("Belfast","Dublin",BUSINESS,new Date());
        expect(pathDatabase.findFlightPath("Belfast","Dublin")).andReturn(90L);
        expect(concessionsEngine.additionalBenefitApplies(1, 27.0)).andReturn(false);
        replayMocks();
        assertEquals(27.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
    public void localFlightEconomyClass() {
        Flight f = new Flight("Belfast","Dublin",ECONOMY,new Date());
        expect(pathDatabase.findFlightPath("Belfast","Dublin")).andReturn(90L);
        expect(concessionsEngine.additionalBenefitApplies(1, 45.0)).andReturn(false);
        replayMocks();
        assertEquals(45.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
    public void internationalFlightFirstClass() {
        Flight f = new Flight("Heathrow","Dublin",FIRST,new Date());
        expect(pathDatabase.findFlightPath("Heathrow","Dublin")).andReturn(350L);
        expect(concessionsEngine.additionalBenefitApplies(1, 70.0)).andReturn(false);
        replayMocks();
        assertEquals(70.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
    public void internationalFlightBusinessClass() {
        Flight f = new Flight("Heathrow","Dublin",BUSINESS,new Date());
        expect(pathDatabase.findFlightPath("Heathrow","Dublin")).andReturn(350L);
        expect(concessionsEngine.additionalBenefitApplies(1, 140.0)).andReturn(false);
        replayMocks();
        assertEquals(140.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
    public void internationalFlightEconomyClass() {
        Flight f = new Flight("Heathrow","Dublin",ECONOMY,new Date());
        expect(pathDatabase.findFlightPath("Heathrow","Dublin")).andReturn(350L);
        expect(concessionsEngine.additionalBenefitApplies(1, 210.0)).andReturn(false);
        replayMocks();
        assertEquals(210.0,calculator.calculateAllowance(f),0.001);
        verifyMocks();
    }
	@Test
	public void multipleLocalFlights() {
		Flight f1 = new Flight("Belfast","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Belfast","Dublin",FIRST,new Date());
		expect(pathDatabase.findFlightPath("Belfast","Dublin")).andReturn(90L).times(2);
        expect(concessionsEngine.additionalBenefitApplies(2, 18.0)).andReturn(false);
        replayMocks();
		assertEquals(18.0,calculator.calculateAllowance(f1,f2),0.001);
		verifyMocks();
	}
	@Test
	//multiple international flights should qualify for extra allowance
	public void multipleInternationalFlights() {
		Flight f1 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f3 = new Flight("Heathrow","Dublin",FIRST,new Date());
		expect(pathDatabase.findFlightPath("Heathrow","Dublin")).andReturn(350L).times(3);
        expect(concessionsEngine.additionalBenefitApplies(3, 210.0)).andReturn(true);
        expect(concessionsEngine.calculateBenefit(3, 210.0)).andReturn(25.0);
        replayMocks();
		assertEquals(235.0,calculator.calculateAllowance(f1,f2,f3),0.001);
		verifyMocks();
	}
	private void verifyMocks() {
		verify(concessionsEngine);
		verify(pathDatabase);
	}
	private void replayMocks() {
		replay(concessionsEngine);
		replay(pathDatabase);
	}
	private TravelAllowanceCalculator calculator;
	private FlightConcessionsEngine concessionsEngine;
	private FlightPathDatabase pathDatabase;
}
