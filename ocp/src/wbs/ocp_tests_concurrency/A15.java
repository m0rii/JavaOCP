package wbs.ocp_tests_concurrency;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//compilerfehler?
//exception?
//ausgabe?
public class A15 {
	public static void main(String[] args) {
		List<String> list = Stream.iterate(1, n -> n + 1).map(i -> Integer.toBinaryString(i)).limit(10)
				.collect(Collectors.toCollection(CopyOnWriteArrayList::new));
		list.add(null);
		for (String s : list) {
			if (s == null || s.length() > 1) {
				list.remove(s);
			}
		}
		System.out.println(list); // [1]
		
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			// iterator kann nicht remove rufen
			itr.remove(); //UnsupportedOperationException // if the remove operation is not supported by this iterator
		}
	}
}