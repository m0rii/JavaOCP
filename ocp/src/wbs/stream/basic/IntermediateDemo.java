package wbs.stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateDemo {
	public static void main(String[] args) {
		
		System.out.println("--- Stream.filter() ---");
		Stream.iterate("a", a -> a + "a").limit(5).filter(a -> a.length() > 2).forEach(System.out::println);
		
		System.out.println("--- Stream.peek() ---");
		Stream<Integer> stream = Stream.of(1, 2, 3, 4);
		System.out.println(stream.peek(System.out::println).count());
		
		System.out.println("--- Stream.flatMap() ---");
		List<Integer> l1 = Arrays.asList(1);
		List<Integer> l2 = Arrays.asList(2, 3);
		List<Integer> l3 = Arrays.asList(3, 4, 5);
		Stream<List<Integer>> stream2 = Stream.of(l1, l2, l3);
		stream2.flatMap(l -> l.stream()).forEach(System.out::println);
		
		
		System.out.println("--- Stream.map() ---");
		Arrays.asList(1, 2, 3, 4, 5).stream().map(i -> Integer.toBinaryString(i)).forEach(System.out::println);
		
		System.out.println("--- Stream.distinct() ---");
		Stream.of(1, 2, 3, 4, 1, 3).distinct().forEach(System.out::println);
		
		System.out.println("--- Stream.sorted() ---");
		Stream.generate(Math::random).limit(10).sorted().forEach(System.out::println);
		
		System.out.println("--- Stream.skip() ---");
		Arrays.asList(1, 2, 3, 4, 5).stream().skip(3).forEach(System.out::println);
	}
}
