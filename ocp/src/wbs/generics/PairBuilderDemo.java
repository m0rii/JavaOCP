package wbs.generics;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.BiPredicate;

public class PairBuilderDemo {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		Set<Dupel<Integer,Integer>> dupels;
		BiPredicate<Integer, Integer> predicate =
				(n1,n2) -> Integer.bitCount(n1) == Integer.bitCount(n2);
				
		for(int i =0 ; i < 200 ; i++) {
			set.add(random.nextInt(100)+2);
		}
		
		dupels = SetUtil.pairBuilder(set, set, predicate);
		for(Dupel<Integer,Integer> dupel : dupels) {
			System.out.println(dupel);
		}

	}

}
