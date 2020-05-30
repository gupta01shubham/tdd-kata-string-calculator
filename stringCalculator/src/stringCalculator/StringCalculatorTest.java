package stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOrEmptyString()  {
		assertEquals(0, StringCalculator.add(""));
	}

}
