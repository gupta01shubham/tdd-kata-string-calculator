package stringCalculator;

import static ch.lambdaj.Lambda.*;

import java.util.List;

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
		String[] tokens = text.split(",|\n");
		return tokens;
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
