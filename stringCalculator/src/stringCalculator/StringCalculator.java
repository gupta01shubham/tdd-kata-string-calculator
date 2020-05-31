package stringCalculator;

import static ch.lambdaj.Lambda.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.lambdaj.function.convert.Converter;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} else {
			String[] tokens = tokenize(numbers);
			List<Integer> number = convert(tokens, toInt());
			return sum(number).intValue();
		}
	}

	private static String[] tokenize(String text) {
		if (usesCustomDelimiterSyntax(text)) {
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
		return numbers.split(customDelimiter);
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
