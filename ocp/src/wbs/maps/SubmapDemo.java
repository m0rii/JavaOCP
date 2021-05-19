package wbs.maps;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SubmapDemo {

	public static void main(String[] args) {

		NavigableMap<Integer, String> map = new TreeMap<>();

		map.put(1, "eins");
		map.put(3, "drei");
		map.put(7, "sieben");
		map.put(10, "zehn");

		NavigableMap<Integer, String> submap = map.subMap(3, true, 7, true);
		System.out.println(submap); // {3=drei, 7=sieben}
		submap.put(4, "vier");
		// submap.put(8, "elf"); // key out of range limit in scope  subMap(3, true, 7, true);
		
		System.out.println(map); // put in submap and result in map! -> {1=eins, 3=drei, 4=vier, 7=sieben, 10=zehn}	
		System.out.println(submap); // {3=drei, 4=vier, 7=sieben}
		map.remove(7);
		System.out.println(map); // {1=eins, 3=drei, 4=vier, 10=zehn}
		System.out.println(submap); // {3=drei, 4=vier}
		
	//	map.put(4, null);
	//	System.out.println(map);
//		map.remove(11);
//		System.out.println(map);
		
		try {
			submap.put(11, "elf");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); // key out of range
		}

	}

}
