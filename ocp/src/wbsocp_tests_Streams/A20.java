package wbsocp_tests_Streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

//welche der folgenden zeilen können aktiviert werden,
//ohne dass es einen compiler-fehler gibt?
public class A20 {
	public static void main(String[] args) {
//A
//Optional<Integer> o1 = Stream.iterate(1, n -> n +
//1).limit(10).reduce((a, b) -> a + b);
//B
//Integer n1 = Stream.iterate(1, n -> n + 1).limit(10)
//.parallel().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
//C
		int n2 = Stream.iterate(1, n -> n + 1).limit(10).parallel().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
//D
OptionalInt o2 = Stream.iterate(1, n -> n + 1).limit(10).mapToInt(n -> n).reduce((a, b) -> a + b);
	}
}