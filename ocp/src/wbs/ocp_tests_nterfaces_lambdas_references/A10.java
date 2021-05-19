package wbs.ocp_tests_nterfaces_lambdas_references;

//wird der folgende code fehlerfrei compiliert?
//falls ja: was wird ausgegeben?
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class A10 {
	public static <T> int count(List<T> list, Predicate<T> predicate) {
		int n = 0;
		for (T t : list) {
			if (predicate.test(t)) {
				n++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		int n;
		n = count(list, i -> i % 2 == 0);
		System.out.println(n);
	}
}