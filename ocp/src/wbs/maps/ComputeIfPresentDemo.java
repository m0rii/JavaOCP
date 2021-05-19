package wbs.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ComputeIfPresentDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		map.computeIfPresent("anna", (k, v) -> v + 10);
		System.out.println(map);
		map.computeIfPresent("anton", (k, v) -> k.length());
		System.out.println(map);
		map.computeIfPresent("anna", (k, v) -> null);
		System.out.println(map);
	}
}
