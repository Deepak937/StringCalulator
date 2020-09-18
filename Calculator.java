package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0,Calculator.add(""));
	}

}
