package wbs.generics;

import java.util.HashSet;
import java.util.Set;

public class FilterDemoMori {

	public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int n = 1;n <= 1000;n++) {
                set.add(n);
        }
        System.out.println(SetUtil.filter(set, n -> Integer.bitCount(n) == 9));
        
        Set<StringBuilder> set2 = new HashSet<>();
        set2.add(new StringBuilder("aaa"));
        set2.add(new StringBuilder("bbb"));
        set2.add(new StringBuilder("zz"));
        set2.add(new StringBuilder("zzzzz"));
        
        System.out.println(SetUtil.filter(set2, s->s.length() == 3));
        System.out.println(SetUtil.filter(set2, s->s.length() == 2));

	}

}
