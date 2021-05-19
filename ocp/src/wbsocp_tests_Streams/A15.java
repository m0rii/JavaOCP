package wbsocp_tests_Streams;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt er?
public class A15 {
	public static void main(String[] args) {
		BiConsumer<Integer, Set<String>> consumer = (i, s) -> System.out.println(i + " -> " + s);
		Map<Integer, Set<String>> map = Stream.of("a", "b", "cc", "dd", "eeee", "fff", "a", "ggg")
				.collect(Collectors.groupingBy(s -> s.length(), Collectors.toSet()));
		map.forEach(consumer);
		/*
		 * 1 -> [a, b]
         2 -> [cc, dd]
         3 -> [ggg, fff]
         4 -> [eeee]

		 */
	}
}