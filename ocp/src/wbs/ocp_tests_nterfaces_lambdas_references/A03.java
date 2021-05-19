package wbs.ocp_tests_nterfaces_lambdas_references;

import java.util.function.Predicate;
import java.util.function.Supplier;

//welche der nachstehenden deklarationen sind compilierungsfähig?
public class A03 {
//A
	Supplier s1 = () -> "s";
//B
	Supplier<CharSequence> s2 = () -> "s";
//C

	Predicate p1 = new Predicate() {
		@Override
		public boolean test(Object o) {
			return false;
		}
	};

//D
	Predicate p2 = o -> o.toString().length() > 0;
}