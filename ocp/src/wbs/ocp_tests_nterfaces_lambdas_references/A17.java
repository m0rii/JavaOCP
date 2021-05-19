package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.Function;
import java.util.stream.Stream;

//compilerfehler?
//ausgabe?
class Pair<L, R> {
	L l;
	R r;

	public Pair(L l, R r) {
		this.l = l;
		this.r = r;
	}
}

public class A17 {
	public static void main(String[] args) {
		Function<String, Pair<String, Integer>> function = s -> new Pair<>(s, s.length());
		Stream.of("a", "bb", "ccc").map(function).mapToInt(p -> p.r).forEach(System.out::println);
	}
}