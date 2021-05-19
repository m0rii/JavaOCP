package wbs.ocp_tests_nterfaces_lambdas_references;

//welche ausgabe erzeugt der nachstehende code?
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class A09 {
	public static <T, R> void m(List<T> values, Function<T, R> function) {
		for (T t : values) {
			R r = function.apply(t);
			System.out.println(r);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String s1 = "hier der funktionswert von ";
		String s2 = "hier der funktionswert von ";
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		m(list, t -> {
			System.out.print(s1 + t + ":");
			return t * t;
		});
	}
}