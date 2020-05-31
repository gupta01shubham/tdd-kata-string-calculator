package stringCalculator;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import ch.lambdaj.function.convert.Converter;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} else if (numbers.contains(",")) {
			String[] tokens = numbers.split(",");
			List<Integer> number = convert(tokens, new Converter<String, Integer>() {

				public Integer convert(String from) {
					return toInt(from);
				}

			});

//			return toInt(tokens[0]) + Integer.parseInt(tokens[1]);
			return sum(number).intValue();
		} else {
			return toInt(numbers);
		}
	}

	private static int toInt(String text) throws NumberFormatException {
		return Integer.parseInt(text);

	}

}
