package wbsocp_tests_Streams;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//welche der folgenden behauptungen sind richtig?
//der code gibt 3 aus
//der code wirft bei ausführung eine exception
//alle method references könnten durch geeignete lambdas ersetzt werden
public class A19 {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("x", "bb", "ccc", "x", "cCc", "BB");
		Function<String, String> keyMapper = String::toUpperCase;
		Function<String, Integer> valueMapper = String::length;
		BinaryOperator<Integer> mergeFunction = (i1, i2) -> i1 + i2;
		Supplier<Map<String, Integer>> supplier = TreeMap::new;
		Map<String, Integer> map = stream.collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));
		System.out.println(map.size()); // 3

	}
}