package wbs.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ComputeIfAbsentDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
// keine änderung, falls key existiert
		map.computeIfAbsent("anna", k -> 123);
		System.out.println(map);
// put, falls key nicht existiert
		map.computeIfAbsent("anton", k -> k.length());
		System.out.println(map);
	}
}
