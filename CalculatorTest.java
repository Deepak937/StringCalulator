package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0,Calculator.add(""));
	}
	
	@Test
	public void shouldReturnNumberOnNumber() {
		assertEquals(1,Calculator.add("1"));
	}
	
	@Test
	public void shouldReturnSumOnTwoNumbersDelimitedByComma() {
		assertEquals(3,Calculator.add("1,2"));
	}
}
