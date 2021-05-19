package wbs.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Memoizer<T, R> {

	private Map<T, R> map = new HashMap<>();

	private Memoizer() {
	}

	private Function<T, R> memoize(Function<T, R> function) {
		return t -> map.computeIfAbsent(t, r -> function.apply(r));
	}

	public static <T, R> Function<T, R> memoized(Function<T, R> function) {
		return new Memoizer<T, R>().memoize(function);
	}
}
