package wbsocp_tests_Streams;

import java.util.stream.Stream;

//welche der folgenden operationen sind assoziativ?
//addition ganzer zahlen -> ja assoziativ
//subtraktion ganzer zahlen ->nein
//multiplikation ganzer zahlen ->ja
//division ganzer zahlen ->nein
//welche ausgabe erzeugt der nachstehende code?
public class A06 {
	public static void main(String[] args) {
		Integer n1 = Stream.iterate(1, n -> n + 1).limit(10).parallel()
				.reduce(0, (a, b) -> a + b, (a, b) -> a + b); // 55
		Integer n2 = Stream.iterate(1, n -> n + 1).limit(5).parallel()
				.reduce(1, (a, b) -> a * b, (a, b) -> a * b); // 120
		
		Integer n3 = Stream.iterate(1, n -> n + 1).limit(0).parallel()
				.reduce(1, (a, b) -> a * b, (a, b) -> a * b); //  limit 0 ist so nur 1 (identity)
		
		Integer n4 = Stream.iterate(0, n -> n + 1).limit(0).parallel()
				.reduce(0, (a, b) -> a + b, (a, b) -> a + b); //  limit 0 so 0 (identity)
		             //(identity)
		
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}
}