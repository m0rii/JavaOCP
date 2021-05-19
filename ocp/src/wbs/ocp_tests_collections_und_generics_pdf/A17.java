package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//welche ausgaben erzeugt der nachstehende code?
//wirft der nachstehende code exceptions?
public class A17 {
	public static void main(String[] args) {
		List<Integer> l1 = Stream.of(2, 3, 5, 7, 11, 13).collect(Collectors.toList());
		List<Integer> l2 = Arrays.asList(2, 3, 5, 7, 11, 13);
		System.out.println(l1.subList(1, 3)); // [3, 5]
		List<Integer> l3 = l1.subList(1, 3);
		l3.add(17);
		System.out.println(l3); // [3, 5, 17]
		System.out.println(l1);// [2, 3, 5, 17, 7, 11, 13]
		l2.add(19);  // java.lang.UnsupportedOperationException
		System.out.println(l2); 
	}
}