package wbs.stream.collectors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// mit methode toSet() , To List() , toCollection
public class ToCollectionDemo {
	public static void main(String[] args) {

		Set<String> set1 = IntStream.rangeClosed(1, 10).mapToObj(i -> Integer.toBinaryString(i))
				.collect(Collectors.toSet());
		System.out.println(set1);

		Set<String> set2 = IntStream.rangeClosed(1, 10).mapToObj(i -> Integer.toBinaryString(i))
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set2);

		List<Integer> list = IntStream.rangeClosed(1, 10).filter(i -> i % 3 == 0).boxed().collect(Collectors.toList());
		System.out.println(list);

	}

}
