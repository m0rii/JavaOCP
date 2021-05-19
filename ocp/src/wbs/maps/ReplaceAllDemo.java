package wbs.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReplaceAllDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		
		stream.forEach(s -> map.put(s, s.length()));
		
		map.replaceAll((k, v) -> v + 10);
		System.out.println(map);
		
		/*
          bitte erläutert, warum die BiFunction in
          replaceAll() wie folgt deklariert ist:
          BiFunction<? super K,? super V,? extends V> function
          warum 2 mal ? super..., und einmal ? extends ?
          
		 */
	}
}