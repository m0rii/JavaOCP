package wbsocp_tests_Streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

//in welchen der folgenden zeilen kann die auskommentierung zurückgenommen werden,
//ohne dass es einen compilerfehler gibt?
public class A01 {
	public static void main(String[] args) {
//A
//Integer v1 = Stream.iterate(1, n -> n + 1).limit(10)
//.reduce((a, b) -> a + b); GEHT nicht weil reduce return type Optional ist und nicht Integer
		
//B
//int v2 = Stream.iterate(1, n -> n + 1).limit(10)
//.reduce((a, b) -> a + b); genau wie A
		
//C
Optional<Integer> o1 = Stream.iterate(1, n -> n + 1).limit(10)
.reduce((a, b) -> a + b);
		
//D
//OptionalInt o2 = Stream.iterate(1, n -> n + 1).limit(10).reduce((a, b) -> a + b);
//  Optional<Integer> getht und nicht  OptionalInt
	}
}