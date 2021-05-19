package wbs.ocp_tests_nterfaces_lambdas_references;

//wird der nachstehende code erfolgreich compiliert?
//falls ja: welche ausgabe erzeugt der code?
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class A11 {
	public static <T, R> void m(List<T> values, Function<T, R> function) {
		for (T t : values) {
			R r = function.apply(t);
			System.out.println(r);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String s1 = "";
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		m(list, t -> {
			System.out.print(s1 + t + ":");
		//	s1 = s1 + "x";  Local variable s1 defined in an enclosing scope must be final or effectively final
			return t * t;
		});
	}
}