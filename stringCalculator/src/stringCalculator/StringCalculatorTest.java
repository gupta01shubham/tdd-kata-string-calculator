package stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString()  {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void shouldReturnNumberOnNumber()  {
		assertEquals(1, StringCalculator.add("1"));
	}

}
