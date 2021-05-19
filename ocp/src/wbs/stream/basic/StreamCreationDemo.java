
package wbs.stream.basic;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCreationDemo {
	public static void main(String[] args) {
		System.out.println("--- Stream.of() ---");
		Stream.of(1, 2, 3).forEach(System.out::println);
		
		System.out.println("--- Arrays.stream() ---");
		Arrays.stream(new int[] { 1, 2, 3 }).forEach(System.out::println);
		
		System.out.println("--- Collection.stream() ---");
		Arrays.asList(1, 2, 3).stream().forEach(System.out::println);
		
		System.out.println("--- Stream.generate() ---");
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		System.out.println("--- Stream.iterate() ---");
		Stream.iterate(1, x -> x + 1).limit(3L).forEach(System.out::println);
	}
}
