package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.BiPredicate;

//welche der folgenden deklarationen sind korrekt?
public class A19 {
	public static void main(String[] args) {
//A
//BiPredicate<String, Integer> bp1 = (String s, i) -> s.length() == i;
		
//B
BiPredicate<String, Integer> bp2 = (String s, Integer i) -> s.length() > 0;

//C
//BiPredicate<String, Integer> bp3 = (String s, Integer i) -> return s.length() == i;

//D
//BiPredicate<String, Integer> bp4 = (String s, Integer i) -> {return s.length() == i};

//E
//BiPredicate<String, Integer> bp5 = (String s, Integer i) -> return {s.length() == i;};

//F
// BiPredicate<String, Integer> bp6 = (String s, Integer i) -> {returns.length() == i;};

	}
}