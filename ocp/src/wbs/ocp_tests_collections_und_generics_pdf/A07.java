package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//kann die auskommentierung von A zurückgenommen werden?
//kann die auskommentierung von B zurückgenommen werden?
//welche ausgaben werden gegebenenfalls erzeugt?
public class A07 {
	public static void main(String[] args) {
		Integer[] ia1 = { 4, 2, 3, 3, 4 };
		AtomicInteger[] ia2 = { new AtomicInteger(1), new AtomicInteger(4), new AtomicInteger(2), new AtomicInteger(3),
				new AtomicInteger(3), new AtomicInteger(4) };
		List<Integer> list1 = Arrays.asList(ia1);
		List<AtomicInteger> list2 = Arrays.asList(ia2);
		Comparator<Number> cmp1 = (n1, n2) -> Integer.compare(n1.intValue(), n2.intValue());
//A
list1.sort(cmp1);
System.out.println(list1); // [2, 3, 3, 4, 4]
//B
list2.sort(cmp1);
System.out.println(list2); // [1, 2, 3, 3, 4, 4]
	}
}