package wbs.generics;

import java.util.HashSet;
import java.util.Set;

public class CountDemo {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for (int n = 1; n <= 1000; n++) {
			set.add(n);
		}
		System.out.println(SetUtil.count(set, n -> Integer.bitCount(n) == 1));

	}

}
