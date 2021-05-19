package wbs.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MergeDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("a", "bb", "ccc", "dddd");
		Map<String, Integer> map = new LinkedHashMap<>();
		stream.forEach(s -> map.put(s, s.length()));
		System.out.println(map); // {a=1, bb=2, ccc=3, dddd=4}
		
		map.put("eeeee", null);  //       vorhandelt und wert ist null 
		System.out.println(map); 	// {a=1, bb=2, ccc=3, dddd=4, eeeee=null}
	
		// key vorhanden, assoziiert mit null
		// p2 wird zum neuen value, bifunction wird ignoriert
		map.merge("eeeee", 5, (oldValue, p2) -> 500);  
		System.out.println(map); // {a=1, bb=2, ccc=3, dddd=4, eeeee=5}
		
		// key vorhanden, assoziiert mit einem wert ungleich null
		// das result von bifunction wird zum neuen wert
		map.merge("eeeee", 55, (oldValue, p2) -> oldValue * 100 + p2);  // vorhandelt und nicht null
		System.out.println(map); // {a=1, bb=2, ccc=3, dddd=4, eeeee=555}
		
		// key vorhanden, bifunction liefert null
		// der entry wird gelöscht
		map.merge("eeeee", 55, (oldValue, p2) -> null); // wenn key vorhandel und assosiate wertt ist nicht null und bifunction liefert null dann DELETE
		
		System.out.println(map); // {a=1, bb=2, ccc=3, dddd=4}
		
		// key nicht vorhanden, p2 != null
		// entry mit p2 als value wird hinzugefügt,
		// bifunction wird ignoriert
		map.merge("ffffff", 6, (oldValue, p2) -> null);
		System.out.println(map); 	// {a=1, bb=2, ccc=3, dddd=4, ffffff=6}
	
		// key nicht vorhanden, p2 == null
		// NullPointerExcpetion
		try {
			map.merge("ggggggg", null, (oldValue, p2) -> null);
			System.out.println(map);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		// key vorhanden, p2 == null:
		// NullPointerExcpetion
		try {
			map.merge("a", null, (oldValue, p2) -> 500);
			System.out.println(map);
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		// merge, quintessenz:
		// key nicht vorhanden und p2 != null:
		// put(), bifunction wird ignoriert
		// key nicht vorhanden und p2 == null:
		// NullPointerException
		// key vorhanden, p2 == null:
		// NullPointerException
		// key vorhanden, p2 != null:
		// bifunction(oldValue, p2) wird zum neuen wert
	}

}
