package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//welche ausgabe erzeugt der nachstehende code?
public class A18 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13);
		System.out.println(Collections.binarySearch(list, 6)); // -4 , bayad too index 3 bashe pas -3-1 = -4
		System.out.println(Collections.binarySearch(list, 7)); // 3
		list.sort(Comparator.reverseOrder()); // 
		System.out.println(list); //[13, 11, 7, 5, 3, 2]
		System.out.println(Collections.binarySearch(list, 6, Comparator.reverseOrder())); // -4
		System.out.println(Collections.binarySearch(list, 7, Comparator.reverseOrder())); // 2
	}
}