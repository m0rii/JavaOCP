package wbsocp_tests_Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt der code?
public class A17 {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("aaaa", "b", "cc", "dd", "eeee", "ffff", "d", "ggg");
		Map<Boolean, List<String>> partition = stream.collect(Collectors.partitioningBy(s -> s.length() == 3));
		
		System.out.println(partition.get(true)); // [ggg]
		
	}
}