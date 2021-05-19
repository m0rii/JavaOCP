package wbs.functional;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Memoizer2Demo {

	public static List<Integer> primfaktoren(int zahl)
			throws IllegalArgumentException {
		if (zahl < 1) {
			throw new IllegalArgumentException(
					"invalid argument: zahl must be greater than zero");
		}
		List<Integer> result = new ArrayList<>();
		for (int teiler = 2; zahl != 1; teiler++) {
			for (; zahl % teiler == 0; zahl /= teiler) {
				result.add(teiler);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		LocalTime time;

		Function<Integer, List<Integer>> function = zahl -> Memoizer2Demo
				.primfaktoren(zahl);
		Function<Integer, List<Integer>> memoizedFunction = Memoizer
				.memoized(function);

		long micros1;
		long micros2;

		time = LocalTime.now();

		for (int zahl = 1_000_000; zahl < 1_001_000; zahl++) {
			function.apply(zahl);
		}
		for (int zahl = 1_000_000; zahl < 1_001_000; zahl++) {
			function.apply(zahl);
		}

		micros1 = ChronoUnit.MICROS.between(time, LocalTime.now());

		time = LocalTime.now();

		for (int zahl = 1_000_000; zahl < 1_001_000; zahl++) {
			memoizedFunction.apply(zahl);
		}
		for (int zahl = 1_000_000; zahl < 1_001_000; zahl++) {
			memoizedFunction.apply(zahl);
		}

		micros2 = ChronoUnit.MICROS.between(time, LocalTime.now());

		System.out.println(micros1);
		System.out.println(micros2);

	}

}
