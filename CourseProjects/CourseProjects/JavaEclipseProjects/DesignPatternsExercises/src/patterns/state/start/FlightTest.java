package patterns.state.start;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class FlightTest {
	@Before
    public void start() throws Exception {
        distances = new HashMap<String,String>();
        distances.put("Belfast City-Heathrow","450");
        distances.put("Belfast International-Birmingham","420");
        distances.put("Belfast City-Belfast International","30");
        distances.put("Birmingham-Heathrow","80");
    }
	@Test
    public void defaultSeating() {
        Flight f = new Flight("Belfast City","Heathrow",null);
        assertSame("Wrong default seating",Seating.STANDARD_CLASS,f.getSeating());
    }
	@Test
    public void reciprocalFlightPaths() {
        Flight f1 = new Flight("Belfast City","Heathrow",null);
        Flight f2 = new Flight("Heathrow","Belfast City",null);
        assertEquals("Cost should be the same",f1.cost(distances),f2.cost(distances),0.001);
    }
	@Test
    public void localFlightFirstClass() {
        Flight f = new Flight("Belfast City","Belfast International",null);
        f.setSeating(Seating.FIRST_CLASS);
        assertEquals("Cost wrong",515,f.cost(distances),0.001);
    }
	@Test
    public void localFlightBusinessClass() {
        Flight f = new Flight("Belfast City","Belfast International",null);
        f.setSeating(Seating.BUSINESS_CLASS);
        assertEquals("Cost wrong",309,f.cost(distances),0.001);
    }
	@Test
    public void localFlightStandardClass() {
        Flight f = new Flight("Belfast City","Belfast International",null);
        f.setSeating(Seating.STANDARD_CLASS);
        assertEquals("Cost wrong",253,f.cost(distances),0.001);
    }
	@Test
    public void nonLocalFlightFirstClass() {
        Flight f = new Flight("Heathrow","Belfast City",null);
        f.setSeating(Seating.FIRST_CLASS);
        assertEquals("Cost wrong",770,f.cost(distances),0.001);
    }
	@Test
    public void nonLocalFlightBusinessClass() {
        Flight f = new Flight("Heathrow","Belfast City",null);
        f.setSeating(Seating.BUSINESS_CLASS);
        assertEquals("Cost wrong",480,f.cost(distances),0.001);
    }
	@Test
    public void nonLocalFlightStandardClass() {
        Flight f = new Flight("Heathrow","Belfast City",null);
        f.setSeating(Seating.STANDARD_CLASS);
        assertEquals("Cost wrong",340,f.cost(distances),0.001);
    }
    private Map<String,String> distances;
}
