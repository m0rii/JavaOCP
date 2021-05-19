package wbs.maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapUtil {

	public static <K, V> Map<V, Collection<K>> invertMap(Map<K, V> map) {
		Map<V, Collection<K>> inverted = new HashMap<V, Collection<K>>();
		Collection<K> keyCollection;	
		for (Map.Entry<K, V> entry : map.entrySet()) {		
			if (!inverted.containsKey(entry.getValue())) {		
				keyCollection = new ArrayList<>();
				inverted.put(entry.getValue(), keyCollection);	
			} else {	
				keyCollection = inverted.get(entry.getValue());
			}
			keyCollection.add(entry.getKey());
		}	
		return inverted;
	}
	
	
	// wir ordnen alle abgordneten des bundestages in gruppen.
	// alle abgeordneten einer gruppe gehören zur selben partei.

	// wir ordnen alle wahlberechtigten eines bundeslandes in gruppen.
	// alle wahlberechtigten einer gruppe gehören zum selben wahlkreis.

	// wir ordnen alle zahlen zwischen 100 und 200 in gruppen.
	// alle zahlen in derselben gruppe haben dieselbe quersumme.

	// methodenname: groupingBy() (in SetUtil)

	// wir testen in GroupingByDemo

	// T: typ (abgeordneter, wahlberechtigter, integer)
	// P: property (partei, wahlkreis, integer)
   
	
	public static <K, V> NavigableMap<V, NavigableSet<K>> invertMap(Map<K, V> map,
            Comparator<? super K> cmpKey, Comparator<? super V> cmpValue) {
    NavigableMap<V, NavigableSet<K>> inverted = new TreeMap<V, NavigableSet<K>>(cmpValue);
    map.forEach((k, v) -> {
            NavigableSet<K> keyCollection = inverted.get(v);
            if (keyCollection == null) {
                    keyCollection = new TreeSet<>(cmpKey);
                    inverted.put(v, keyCollection);
            }
            keyCollection.add(k);

    });
    return inverted;
}

}
