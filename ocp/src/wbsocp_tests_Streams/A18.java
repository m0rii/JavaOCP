package wbsocp_tests_Streams;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.Stream;

//welch der folgenden zeilen können aktiviert werden,
//ohne dass es einen compilerfehler gibt?
public class A18 {
	public static void main(String[] args) {
//A
//Stream.of("aa", "zz", "xx").sort().forEach(System.out::println); // sorted nicht sort
		
//B
Stream.of("aa", "zz", "xx").sorted().forEach(System.out::println);

//C
Stream.of("aa", "zz", "xx").sorted(Comparator.reverseOrder())
.forEach(System.out::println);

//D
//OptionalInt o = Stream.of("aa", "zz",
//"xx").mapToInt(String::length).sum(); return type muss int sein

//E
int n1 = Stream.of("aa", "zz", "xx").mapToInt(String::length).sum();

//F
//int n2 = Stream.of("aa", "zz", "xx").mapToInt(s -> s.length())
//.summaryStatistics().getCount();

	}
}