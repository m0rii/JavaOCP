package wbs.ocp_tests_concurrency;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//compilerfehler?
//exception?
public class A14 {
	public static void main(String[] args) {
		Set<String> set = Stream.iterate(1, n -> n + 1).map(i -> Integer.toBinaryString(i)).limit(10)
				.collect(Collectors.toSet());
		System.out.println(set); // [11, 110, 1, 100, 111, 101, 1001, 1000, 1010, 10]
		ConcurrentSkipListSet<String> set2 = new ConcurrentSkipListSet<String>(set); // navigable set und durfen nicht null haben
		set2.forEach(s -> set2.add("xxx"));
		set2.add(null); // exception java.lang.NullPointerException // navigable set kann nicht null haben
		System.out.println(set2); // ohne null [1, 10, 100, 1000, 1001, 101, 1010, 11, 110, 111, xxx]
	}
}
