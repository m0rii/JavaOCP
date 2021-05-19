package wbsocp_tests_Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//welch ausgabe erzeugt der nachstehende code?
public class A14 {
	public static void main(String[] args) {
		Map<Integer, List<String>> map = Stream.of("a", "b", "cc", "dd", "eeee", "fff", "a", "ggg")
				.collect(Collectors.groupingBy(s -> s.length()));
		System.out.println(map.get(1).size()); // 3 vhjon 3 ta 1 harfi darim
		System.out.println(map); // {1=[a, b, a], 2=[cc, dd], 3=[fff, ggg], 4=[eeee]}
	}
}