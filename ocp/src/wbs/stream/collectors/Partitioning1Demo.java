package wbs.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning1Demo {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("aaaa", "b", "cc", "dd", "eeee", "ffff", "d", "ggg");
		Map<Boolean, List<String>> partition1 = stream.collect(Collectors.partitioningBy(s -> s.length() == 3));
		System.out.println(partition1);
// {false=[aaaa, b, cc, dd, eeee, ffff, d], true=[ggg]}
	}
}