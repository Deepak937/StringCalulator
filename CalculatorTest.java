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
	
	@Test
	public void shouldReturnSumOnMultipleNumbers() {
		assertEquals(6,Calculator.add("1,2,3"));
				
	}
	
	@Test
	public void shouldAcceptNewlineAsValidDelimiter() {
		assertEquals(6,Calculator.add("1\n2,3"));
				
	}
	
	@Test
	public void shouldAcceptCustomDelimiterSyntax() {
		assertEquals(3,Calculator.add("//;\n1;2"));
				
	}
	
	@Test
	public void customDelimeterCouldBeAlsoARegExpSpecialChar() {
		assertEquals(3,Calculator.add("//.\n1.2"));
				
	}
	@Test
	public void shouldRaiseExceptionOnNegatives() {
		try 
		{
			Calculator.add("-1,2,3");
			fail("Exception expected.");
		}catch (RuntimeException ex) {
			//	ok
		}
	}
	@Test
	public void exceptionMessageShouldContainTheNegativeNumber() {
		try 
		{
			Calculator.add("-1,-2,3");
			fail("Exception expected.");
		}catch (RuntimeException ex) {
			assertEquals("Negatives not allowed: -1, -2", ex.getMessage());
		}
	}
	
	
}
