package wbs.maps;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/*
 * gibt es eine IS A beziehung zwischen Map und Collection? nein
   gibt es eine IS A beziehung zwischen Map und Iterable? nein
   was ist ein Map.Entry? ist das ein nested interface? Enclosing Interface
   wie bekommt man alle keys einer map?
   wie bekommt man alle values einer map?
   wie findet man zu einem key den zugehörigen value?
   wie fügt man ein neues key-value-paar in eine map ein?
   wie findet man heraus, ob eine map einen bestimmten
   key enthält?
   was sortiert eine TreeMap, und nach welchem kriterium
   wird sortiert?
   erlaubt eine HashMap null-keys? null-values?
   erlaubt eine TreeMap null-keys? null-values?
   welche der varianten in SimpleMapDemo haben
   eine eher gute performance, und welche eine eher schlechte?
   was ist der parameter von foreach() in Map?
 */

public class SimpleMapDemo {
	public static void main(String[] args) {
// diamond-operator (ab 1.7: type inference)
		NavigableMap<String, String> dict = new TreeMap<>();
		dict.put("eins", "one");
		dict.put("zwei", "two");
		dict.put("drei", "three");
		dict.put("vier", "four");
		dict.put("fünf", "five");
// wir geben die map aus.
// variante 1:
		System.out.println("--------");
		System.out.println(dict);
// variante 2: 
		System.out.println("--------");
		for (String key : dict.keySet()) { // proformance nicht nur jedesmal ruge get methode auf
			System.out.println(key + " -> " + dict.get(key));
		}
// variante 3:
		System.out.println("--------");
		String key;
		Iterator<String> itrKeys = dict.keySet().iterator();
		while (itrKeys.hasNext()) {
			key = itrKeys.next();
			System.out.println(key + " -> " + dict.get(key)); // proformance schlecht
		}
// variante 4:
		System.out.println("---- ---");
		for (Map.Entry<String, String> entry : dict.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue()); // performance is besser und schneller
		}

		// variante 5
		System.out.println("--------");
		Map.Entry<String, String> entry;
		Iterator<Map.Entry<String, String>> itrEntries = dict.entrySet().iterator(); // performance is gleich variante 4 und gut
		while (itrEntries.hasNext()) {
			entry = itrEntries.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue()); 
		}
		// variante 6
		System.out.println("--------");
		dict.forEach((k, v) -> System.out.println(k + " -> " + v)); // proformence ist genau wie 4 und 5
	}
}
