package exercise.tdd.mocking.start;

import static org.junit.Assert.*;
import static exercise.tdd.mocking.start.Seating.*;
import java.util.Date;

import org.junit.*;

import exercise.tdd.mocking.finish.jmock.FlightConcessionsEngine;
import exercise.tdd.mocking.finish.jmock.FlightPathDatabase;

public class TravelAllowanceCalculatorTest {
	@Before
	public void start() {
		calculator = new TravelAllowanceCalculator(null,null);
	}
	@Test
	@Ignore
    public void localFlightFirstClass() {
        Flight f = new Flight("Belfast","Dublin",FIRST,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
    public void localFlightBusinessClass() {
        Flight f = new Flight("Belfast","Dublin",BUSINESS,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
    public void localFlightEconomyClass() {
        Flight f = new Flight("Belfast","Dublin",ECONOMY,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
    public void internationalFlightFirstClass() {
        Flight f = new Flight("Heathrow","Dublin",FIRST,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
    public void internationalFlightBusinessClass() {
        Flight f = new Flight("Heathrow","Dublin",BUSINESS,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
    public void internationalFlightEconomyClass() {
        Flight f = new Flight("Heathrow","Dublin",ECONOMY,new Date());
        assertEquals(123,calculator.calculateAllowance(f),0.001);
    }
	@Test
	@Ignore
	public void multipleLocalFlights() {
		Flight f1 = new Flight("Belfast","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Belfast","Dublin",FIRST,new Date());
		 assertEquals(1285,calculator.calculateAllowance(f1,f2),0.001);
	}
	@Test
	@Ignore
	//Multiple international flights should qualify for extra allowance
	public void multipleInternationalFlights() {
		Flight f1 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f2 = new Flight("Heathrow","Dublin",FIRST,new Date());
		Flight f3 = new Flight("Heathrow","Dublin",FIRST,new Date());
		assertEquals(123,calculator.calculateAllowance(f1,f2,f3),0.001);
	}
	private TravelAllowanceCalculator calculator;
	private FlightConcessionsEngine concessionsEngine;
	private FlightPathDatabase pathDatabase;
}
