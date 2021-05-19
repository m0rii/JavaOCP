package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//nennen Sie 3 Klassen, die das interface Queue implementieren.
// LinkedBlockingDequed

//nennen Sie 2 Klassen, die das interfaces Deque implementieren.
//

//nennen Sie 1 Klasse, die das interface BlockingDeque implementiert.
// Queue<>

//vor welchen der nachstehenden zeilen kann die auskommentierung
//zurückgenommen werden?
// 

public class A15 {
	public static void m1(List<? super CharSequence> list) {
	}

	public static void m2(List<? extends CharSequence> list) {
	}

	public static Object m3(List<?> list) {
		return list.get(0);
	}

	public static Object m4(List<Object> list) {
		return list.get(0);
	}

	public static void main(String[] args) {
//A
		m1(Arrays.asList("a", "b", "c"));

//B
		m2(Arrays.asList(new StringBuffer()));

//C
		m3(Arrays.asList(new StringBuilder()));

//D
		List<StringBuilder> list1 = new ArrayList<StringBuilder>();

//E
		List<Object> list2 = new ArrayList<>();

//F
//m4(list1); list 1 type ist StringBuilder und m4 ist nur object

//G
		m4(list2);
	}
}