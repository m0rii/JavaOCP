package wbsocp_tests_Streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

//in welchen der folgenden zeilen kann die auskommentierung
//zurückgenommen werden, ohne dass es einen compilerfehler gibt?
public class A07 {
	public static void main(String[] args) {
//A
//Optional<Integer> o1 = IntStream.iterate(1, n -> n + 1).limit(10).findAny(); // findAny return an OptionalInt 
		
//B
OptionalInt o2 = IntStream.iterate(1, n -> n + 1).limit(10).findAny();
		
//C
IntStream.iterate(1, n -> n + 1).limit(10).findAny().ifPresent(System.out::println); // 1
	}
}