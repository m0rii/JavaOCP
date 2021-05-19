package wbsocp_tests_Streams;

import java.util.Optional;
import java.util.stream.Stream;

//welche der folgenden methoden von Stream sind static?
//concat()
//reduce()
//of()
//empty()
//toArray()
//wo kann die auskommentierung zurückgenommen werden,
//ohne dass es einen compiler-fehler oder eine exception gibt?
public class A04 {
	public static void main(String[] args) {
//A
		System.out.println(Stream.of("a", "b", "c").toArray()[0]); // a
//B
		Optional<String> op1 = Stream.<String>empty().findAny();
//C
		Stream<String> stream1 = Stream.<String>empty();
//D
		Stream<String> stream2 = Stream.empty();
	}
}