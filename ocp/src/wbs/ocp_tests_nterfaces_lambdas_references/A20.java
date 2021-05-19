package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//welche ausgabe erzeugt der folgende code?
public class A20 {
	public static void main(String[] args) {
		Function<Integer, String> f1 = i -> Integer.toString(i);
		Function<String, StringBuilder> f2 = StringBuilder::new;
		Predicate<StringBuilder> p = s -> {
			String s1 = s.toString();
			String s2 = s.reverse().toString();
			return s1.equals(s2);
		};
		IntStream.rangeClosed(10, 99).boxed().map(f1.andThen(f2)).filter(p).forEach(System.out::println);
		// boxed() Returns a Stream consisting of the elements of this stream, each boxed to an Integer. 
	}
}
