package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

//welche ausgabe erzeugt der nachstehende code?
//wirft der nachstehende code exceptions?
public class A19 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13);
		SortedSet<Integer> set = new TreeSet<Integer>(list);
		// subset ba elementa kar mikone
		SortedSet<Integer> subset = set.subSet(4, 7); // element bein 4 ta 6 ke mishe faghat 5
		System.out.println(subset); // [5]
		subset.add(6);
		System.out.println(set); // [2, 3, 5, 6, 7, 11, 13]
		subset.add(7); // chon subset element bein 4 ta 6 ast  java.lang.IllegalArgumentException: key out of range
		System.out.println(set);
	}
}