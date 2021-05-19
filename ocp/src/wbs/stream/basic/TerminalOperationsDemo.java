package wbs.stream.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperationsDemo {
	public static void main(String[] args) {
		System.out.println("--- Stream.toArray() ---");
		System.out.println(Arrays.toString(Stream.of(1, 2, 3).toArray()));
		
		System.out.println("--- Stream.max() ---"); // max() liefert optional
		Stream<String> stream = Stream.of("a", "ccc", "bb");
		System.out.println(stream.max(Comparator.naturalOrder()).get());// check mikone ke type stream natural ordering dare ya na age nadashte bashe compiler fehler
		
		System.out.println("--- Stream.min() ---");  // min() liefert optional
		stream = Stream.of("a", "ccc", "bb");
		System.out.println(stream.min(Comparator.reverseOrder()).get());// check mikone ke type stream natural ordering dare ya na age nadashte bashe compiler fehler
		
		System.out.println("--- Stream.count() ---");
		System.out.println(Stream.of("a", "ccc", "bb").count());
		
		System.out.println("--- Stream.allMatch() ---");
		System.out.println(Stream.of("a", "ccc", "bb").allMatch(s -> s.length() > 0));
		
		System.out.println("--- Stream.noneMatch() ---");
		System.out.println(Stream.of("a", "ccc", "bb").noneMatch(s -> s.length() > 4));
		
		System.out.println("--- Stream.anyMatch() ---");
		System.out.println(Stream.of("a", "ccc", "bb").anyMatch(s -> s.length() == 4));
		
		System.out.println("--- Stream.findFirst() ---");
		Optional<String> optional = Stream.of("a", "ccc", "bb").findFirst(); // findFirst() liefert optional
		optional.ifPresent(System.out::println);
		optional = Stream.of("a", "ccc", "bb").limit(0).findFirst();
		System.out.println(optional.orElseGet(() -> "uups..."));
		
		System.out.println("--- Stream.findAny() ---"); 
		Stream.of("a", "ccc", "bb").findAny().ifPresent(System.out::println); // findAny() liefert optional
		
	}
}
