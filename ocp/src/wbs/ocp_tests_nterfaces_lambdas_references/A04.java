package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.BiFunction;
import java.util.function.Consumer;

//welch der folgenden blöcke können aktiviert werden, ohne dass es einen
//compiler-fehler gibt?
public class A04 {
	public static Object m1(BiFunction f) {
		return "s";
	}

	public static <T, U, R> R m2(BiFunction<T, U, R> f) {
		return null;
	}

	public static <T> void f(Consumer<T> consumer) {
	}

	public static void main(String[] args) {
//A
		m1((o1, o2) -> o1.toString() + o2.toString());

//B
//m1( (n, m) -> n + m);

//C
		m2((String a, String b) -> a + b);
	}
}