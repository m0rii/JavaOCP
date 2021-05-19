package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//nennen sie drei thread-sichere map-implementierungen
// cocurent hashmap , ?

//ausgabe
public class A09 {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("anna", "hanna", "hannelore");
		Map<String, Integer> map = new HashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		map.computeIfAbsent("anna", k -> 123); // anna andert nicht
		map.computeIfAbsent("anton", k -> k.length()); // anton zu gefugt
		System.out.println(map.get("anna")); // 4
		System.out.println(map.size()); // 4 chon anton ezafe shod
		System.out.println(map); // {hannelore=9, anton=5, anna=4, hanna=5}
	}
}