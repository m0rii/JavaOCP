package wbsocp_tests_Streams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt er?
public class A16 {
	public static void main(String[] args) {
		Map<Integer, String> map = Stream.of("a", "b", "cc", "dd", "eeee", "ffff", "a", "ggg")
				.collect(Collectors.groupingBy(s -> s.length(), Collectors.joining("+")));
		System.out.println(map.getOrDefault(6, "66")); // 66 chon 6 nawadarium
		System.out.println(map.get(1)); // key 1 so a+b+a
		System.out.println(map); // {1=a+b+a, 2=cc+dd, 3=ggg, 4=eeee+ffff}
	}
}
