package roman.numerals.finish.ok;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyTest {
	@Test
	public void conversions() {
		assertEquals("I",Exercise.convert(1));
		assertEquals("III",Exercise.convert(3));
		assertEquals("IV",Exercise.convert(4));
		assertEquals("V",Exercise.convert(5));
		assertEquals("VI",Exercise.convert(6));
		assertEquals("IX",Exercise.convert(9));
		assertEquals("X",Exercise.convert(10));
		assertEquals("XI",Exercise.convert(11));
		assertEquals("XL",Exercise.convert(40));
		assertEquals("XLI",Exercise.convert(41));
		assertEquals("L",Exercise.convert(50));
		assertEquals("LI",Exercise.convert(51));
		assertEquals("XC",Exercise.convert(90));
		assertEquals("XCI",Exercise.convert(91));
		assertEquals("C",Exercise.convert(100));
		assertEquals("CI",Exercise.convert(101));
	}
}
