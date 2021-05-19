package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Optional;

//welche ausgabe erzeugt der nachstehende code?
public class A05 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Optional<String> o1 = Optional.of("anna");
		Optional<String> o2 = Optional.empty();
		Optional o3 = Optional.empty();
		Object o;
		o1.ifPresent(System.out::println); // anna
		System.out.println(o2.isPresent()); // false
		o = o3.orElse("hanna");
		System.out.println(o); // hanna
		o = o3.orElseGet(() -> "nasowas");  // nasowas
		System.out.println(o);
		try {
			o = o3.orElseThrow(() -> new RuntimeException());
		} catch (Throwable e) {
			System.out.println("uuuups...."); // uuuups....
		}
	}
}