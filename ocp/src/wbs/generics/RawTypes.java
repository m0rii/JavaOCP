package wbs.generics;

import java.util.function.Predicate;

@SuppressWarnings("rawtypes")
class MyClass implements Comparable {
	@Override
	public int compareTo(Object o) {
		return 0;
	}
}

@SuppressWarnings("rawtypes")
class MyPredicate implements Predicate {

	Predicate predicate = (Object o) -> o.toString().length() > 5; // o ist ype Object 

	@Override
	public boolean test(Object t) {
		return false;
	}
}
