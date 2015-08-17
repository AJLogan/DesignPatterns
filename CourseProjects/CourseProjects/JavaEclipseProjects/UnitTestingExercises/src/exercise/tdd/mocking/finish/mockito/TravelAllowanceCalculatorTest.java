package exercise.tdd.mocking.finish.mockito;

import static exercise.tdd.mocking.finish.mockito.Seating.*;
import static org.junit.Assert.*;
import java.util.Date;

import org.junit.*;
import static org.mockito.Mockito.*;

public class TravelAllowanceCalculatorTest {
	@Before
	public void start() {
		concessionsEngine = mock(FlightConcessionsEngine.class);
		pathDatabase = mock(FlightPathDatabase.class);
		calculator = new TravelAllowanceCalculator(concessionsEngine,pathDatabase);
	}
	@Test
    public void localFlightFirstClass() {
        Flight f = new Flight("Belfast","Dublin",FIRST,new Date());
        when(pathDatabase.findFlightPath("Belfast","Dublin")).thenReturn(90L);
        when(concessionsEngine.additionalBenefitApplies(1, 9.0)).thenReturn(false);

        assertEquals(9.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void localFlightBusinessClass() {
        Flight f = new Flight("Belfast","Dublin",BUSINESS,new Date());
        when(pathDatabase.findFlightPath("Belfast","Dublin")).thenReturn(90L);
        when(concessionsEngine.additionalBenefitApplies(1, 27.0)).thenReturn(false);

        assertEquals(27.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void localFlightEconomyClass() {
        Flight f = new Flight("Belfast","Dublin",ECONOMY,new Date());
        when(pathDatabase.findFlightPath("Belfast","Dublin")).thenReturn(90L);
        when(concessionsEngine.additionalBenefitApplies(1, 45.0)).thenReturn(false);

        assertEquals(45.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightFirstClass() {
        Flight f = new Flight("Heathrow","Dublin",FIRST,new Date());
        when(pathDatabase.findFlightPath("Heathrow","Dublin")).thenReturn(350L);
        when(concessionsEngine.additionalBenefitApplies(1, 70.0)).thenReturn(false);

        assertEquals(70.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightBusinessClass() {
        Flight f = new Flight("Heathrow","Dublin",BUSINESS,new Date());
        when(pathDatabase.findFlightPath("Heathrow","Dublin")).thenReturn(350L);
        when(concessionsEngine.additionalBenefitApplies(1, 140.0)).thenReturn(false);

        assertEquals(140.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
    public void internationalFlightEconomyClass() {
        Flight f = new Flight("Heathrow","Dublin",ECONOMY,new Date());
        when(pathDatabase.findFlightPath("Heathrow","Dublin")).thenReturn(350L);
        when(concessionsEngine.additionalBenefitApplies(1, 210.0)).thenReturn(false);
 
        assertEquals(210.0,calculator.calculateAllowance(f),0.001);
    }
	@Test
	public void multipleLocalFlights() {
		Flight f1 = new Flight("Belfast","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Belfast","Dublin",FIRST,new Date());
		
		when(pathDatabase.findFlightPath("Belfast","Dublin")).thenReturn(90L);
        when(concessionsEngine.additionalBenefitApplies(2, 18.0)).thenReturn(false);
 
		assertEquals(18.0,calculator.calculateAllowance(f1,f2),0.001);
		verify(pathDatabase,times(2)).findFlightPath(anyString(),anyString());
	}
	@Test
	//multiple international flights should qualify for extra allowance
	public void multipleInternationalFlights() {
		Flight f1 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f3 = new Flight("Heathrow","Dublin",FIRST,new Date());
		
		when(pathDatabase.findFlightPath("Heathrow","Dublin")).thenReturn(350L);
		when(concessionsEngine.additionalBenefitApplies(3, 210.0)).thenReturn(true);
		when(concessionsEngine.calculateBenefit(3, 210.0)).thenReturn(25.0);

		assertEquals(235.0,calculator.calculateAllowance(f1,f2,f3),0.001);
		verify(pathDatabase,times(3)).findFlightPath(anyString(),anyString());
	}
	private TravelAllowanceCalculator calculator;
	private FlightConcessionsEngine concessionsEngine;
	private FlightPathDatabase pathDatabase;
}
