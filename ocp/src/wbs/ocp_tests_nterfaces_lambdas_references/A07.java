package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.Optional;
import java.util.stream.Stream;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt der code?
public class A07 {
	public static void main(String[] args) {
		String s1 = Stream.generate(() -> " ").limit(20).reduce("", (s11, s12) -> s11 + s12);
		System.out.println(s1.length());
		System.out.println(s1);
		Optional<String> optional = Stream.generate(() -> " ").limit(20).reduce((s21, s22) -> s21 + s22);
		optional.ifPresent(System.out::println);
	}
}