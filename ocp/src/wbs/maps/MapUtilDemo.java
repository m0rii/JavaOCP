package wbs.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MapUtilDemo {
	
	public static void main(String[] args) {
		
		NavigableMap<String, String> dict = new TreeMap<>();
		dict.put("eins", "one");
		dict.put("zwei", "two");
		dict.put("drei", "three");
		dict.put("vier", "four");
		dict.put("fünf", "five");
		
		dict.forEach((k, v) -> System.out.println(k + " -> " + v));
		
		System.out.println(MapUtil.invertMap(dict));
		
		System.out.println("---------------------------------------------");
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int n=1 ; n <= 100; n++) {
			map.put(n, Integer.bitCount(n));
		}
		
	
        MapUtil.invertMap(map)
                        .forEach((k, v) -> System.out.println(k + " -> " + v));
        
        System.out.println("----------invertmap last version---------");
        Comparator<Integer> cmp = (n1,n2) -> Integer.compare(n2, n1);
        MapUtil.invertMap(map, cmp, cmp).forEach((k,v)-> System.out.println(k + " -> " +v));
        // (map, null, null) null ist erlaubt und compiled aber dann kommt exception
        
        
		
		

		
		
		
	}
	


}
