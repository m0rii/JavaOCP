package wbsocp_tests_Streams;

import java.util.stream.IntStream;

//welche der folgenden methoden von Stream
//verarbeiten immer alle elemente des streams? alle 5 elemente
//findFirst()
//findAny()
//allMatch()
//anyMatch()
//noneMatch()
//ist das ergebnis exakt voraussagbar?
public class A05 {
	public static void main(String[] args) {
		Object o = IntStream.iterate(1, n -> n + 2).parallel().limit(20).findFirst();
		System.out.println(o.getClass().getSimpleName()); // OptionalInt
		System.out.println(o.toString()); // OptionalInt[1]
	}
}