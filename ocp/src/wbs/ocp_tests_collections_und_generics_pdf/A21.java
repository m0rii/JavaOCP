package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//welche ausgabe erzeugt der nachstehende code?
public class A21 {
	public static void main(String[] args) {
		Function<String, String> f1 = Function.identity();
		Function<String, Integer> f2 = s -> s.length();
		BiConsumer<String, Integer> consumer = (k, v) -> System.out.println(k + " -> " + v);
		BiFunction<Integer, Integer, Integer> f3 = (i1, i2) -> i1 + i2;
		Map<String, Integer> map = Stream.of("aaa", "bbb", "ccc", "ee").collect(Collectors.toMap(f1, f2));
		NavigableMap<String, Integer> map2 = new TreeMap<>(map);
		map2.forEach(consumer);
		System.out.println("---------");
		map2.merge("aaa", Integer.valueOf(100), f3);
		System.out.println(map2.get("aaa"));
		System.out.println("----------");
		map2.merge("ddd", 100, f3);
		System.out.println(map2.get("ddd"));
		System.out.println("----------");
		map2.merge("ddd", 100, f3);
		System.out.println(map2.get("ddd"));
	}
}