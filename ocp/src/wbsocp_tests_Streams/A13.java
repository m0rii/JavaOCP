package wbsocp_tests_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe wird erzeugt?
public class A13 {
	public static void main(String[] args) {
		List<String> l1 = Stream.of("anna", "manna").collect(Collectors.toCollection(ArrayList::new));
		List<String> l2 = Stream.of("honey", "nanny").collect(Collectors.toCollection(ArrayList::new));
		Stream.of(l1, l2).flatMap(l -> l.stream()).sorted().forEach(System.out::println);
		// eachzeil : anna honey manna nanny
		
	
		
	}
}