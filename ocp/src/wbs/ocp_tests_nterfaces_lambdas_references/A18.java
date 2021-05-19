package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

//welche ausgabe erzeugt der folgende code?
public class A18 {
	public static void main(String[] args) {
		IntFunction<String> f1 = n -> n + "";
		ToIntFunction<String> f2 = Integer::parseInt;
		IntStream.range(1, 5).mapToObj(f1).mapToInt(f2).forEach(System.out::println);
	// Parameters:startInclusive the (inclusive) initial valueendExclusive the exclusive upper bound
	}
}
