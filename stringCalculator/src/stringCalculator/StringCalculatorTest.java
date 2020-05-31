package stringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void shouldReturnNumberOnNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void shouldReturnSumOnTwoNumbersDelimitedByComma() {
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void shouldReturnSumOnMultipleNumbers() {
		assertEquals(6, StringCalculator.add("1,2,3"));
	}
	
	@Test
	public void shouldAcceptNewLineAsValidDelimiter() {
		assertEquals(6, StringCalculator.add("1,2\n3"));
	}

}
