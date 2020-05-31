package stringCalculator;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.lambdaj.function.convert.Converter;

public class StringCalculator {

	public static int add(String numbers) {
		List<Integer> number = parseNumbers(numbers);
		ensureAllNonNegatives(number);
		return sum(number).intValue();
	}

	private static List<Integer> parseNumbers(String numbers) {
		String[] tokens = tokenize(numbers);
		List<Integer> number = convert(tokens, toInt());
		return number;
	}

	private static void ensureAllNonNegatives(List<Integer> number) {
		List<Integer> negatives = filter(lessThan(0), number);
		if (negatives.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + join(negatives));
		}
	}

	private static String[] tokenize(String text) {
		if (text.isEmpty()) {
			return new String[0];
		} else if (usesCustomDelimiterSyntax(text)) {
			return splitUsingCustomDelimiterSyntax(text);
		} else {
			return splitUsingNewLinesAndCommas(text);
		}
	}

	private static boolean usesCustomDelimiterSyntax(String text) {
		return text.startsWith("//");
	}

	private static String[] splitUsingNewLinesAndCommas(String text) {
		String[] tokens = text.split(",|\n");
		return tokens;
	}

	private static String[] splitUsingCustomDelimiterSyntax(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		m.matches();
		String customDelimiter = m.group(1);
		String numbers = m.group(2);
		return numbers.split(Pattern.quote(customDelimiter));
	}

	private static Converter<String, Integer> toInt() {
		return new Converter<String, Integer>() {
			public Integer convert(String from) {
				return toInt(from);
			}
		};
	}

	private static int toInt(String text) throws NumberFormatException {
		return Integer.parseInt(text);

	}

}
