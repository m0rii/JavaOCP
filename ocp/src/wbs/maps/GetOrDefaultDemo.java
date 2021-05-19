package wbs.maps;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class GetOrDefaultDemo {
	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		System.out.println(map.getOrDefault("anna", 12345));
		System.out.println(map.getOrDefault("manna", 12345));
		
		
	
	}
}