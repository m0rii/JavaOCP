package wbs.generics;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class FilterDemo {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for (int n = 1; n <= 1000; n++) {
			set.add(n);
		}
		
		// das subset ist unsortiert...
		System.out.println(SetUtil.filter(set, n -> Integer.bitCount(n) == 7));

		Comparator<Integer> cmp = (n1, n2) -> {
			int diff = Integer.bitCount(n1) - Integer.bitCount(n2);
			// return diff != 0 ? diff : Integer.compare(n1, n2);
			return diff;   // das wäre nicht so gut ... ! warum?
		};

		// das subset ist sortiert...
		System.out.println(
				SetUtil.filter(set, n -> Integer.bitCount(n) == 7, cmp));
	}
}
