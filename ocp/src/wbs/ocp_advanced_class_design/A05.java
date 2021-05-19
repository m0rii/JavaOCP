package wbs.ocp_advanced_class_design;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

// compilerfehler?
// ausgabe?
public enum A05 {
	A, B, C;

	public static void main(String[] args) {
		NavigableSet<A05> set = new TreeSet<>(); // Kar mikone chon enum natural ordering dare va tree set bayad ordering dashte bashe age nadasht khata midad classcastexception
		System.out.println(set.addAll(Arrays.asList(A05.values()))); // true
		System.out.println(set); // [A, B, C]
		set = new ConcurrentSkipListSet<A05>();
		System.out.println(set.addAll(Arrays.asList(A05.values()))); // true
		System.out.println(set); // [A, B, C]

	}
}