package wbs.stream.collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning2Demo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("aaaa", "b", "cc", "dd", "eeee", "ffff", "d", "ggg");
		Map<Boolean, Integer> partition2 = stream
				.collect(Collectors.partitioningBy(s -> s.length() == 3, Collectors.summingInt(s -> s.length())));
		System.out.println(partition2);
// {false=18, true=3}
	}
}
