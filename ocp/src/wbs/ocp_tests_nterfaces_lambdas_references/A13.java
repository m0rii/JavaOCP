package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

//ausgabe?
public class A13 {
	public static void main(String[] args) {
		List<ToIntFunction<String>> functionList = new ArrayList<>();
		functionList.add(s -> s.length());
		functionList.add(s -> s.charAt(0) - '0');
		functionList.stream().forEach(f -> System.out.println(f.applyAsInt("54321")));
	}
}