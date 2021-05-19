package wbsocp_tests_Streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe wird erzeugt?
public class A10 {
	public static void main(String[] args) {
		String[] sa1 = { "anna", "hanna" };
		String[] sa2 = { "manna", "money" };
		Function<String[], Stream<String>> function = a -> Arrays.stream(a);
		Stream.of(sa1, sa2).flatMap(function).forEach(System.out::println); // anna hanna manna money
		
		
		
	}
}

