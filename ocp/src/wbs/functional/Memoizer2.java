package wbs.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Memoizer2<T, R> {

	private Memoizer2() {
	}

	abstract Function<T, R> memoize(Function<T, R> function);

	public static <T, R> Function<T, R> memoized(Function<T, R> function) {
		return new Memoizer2<T, R>() {
			private Map<T, R> map = new HashMap<>();
			@Override
			Function<T, R> memoize(Function<T, R> function) {
				return t -> map.computeIfAbsent(t, r -> function.apply(r));
			}
		}.memoize(function);
	}
}
