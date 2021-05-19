package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

//in welchen zeilen kann die auskommentierung zurückgenommen
//werden, ohne dass es eine exception gibt?
public class A04 {
	public static void main(String[] args) {
		// * key kann nicht null sein
		
		// NavigableSet , NavigableSet -> TreeSet  alles sortiert
		
		// SortedMap , NavigableMap ->TreeMap alles sortiert und
		
//A
new HashSet<String>().add(null); // sortiert nicht
//B
// new TreeSet<String>().add(null); // java.lang.NullPointerException
//C
new HashMap<String, String>().put(null, "a");
//D
new HashMap<String, String>().put("a", null);
//E
// new TreeMap<String, String>().put(null, "a"); java.lang.NullPointerException
//F
new TreeMap<String, String>().put("a", null);
//G
// new ConcurrentSkipListSet<String>().add(null); java.lang.NullPointerException // implementiert NavigableSet so sortiert
//H
new CopyOnWriteArrayList<String>().add(null);

       // 
	}
}