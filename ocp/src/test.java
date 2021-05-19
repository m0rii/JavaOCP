import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.HashSet;

import java.util.Set;

import java.util.TreeSet;

class C151 {
	String s;
	int n;

	public C151(String s, int n) {
		this.s = s;
		this.n = n;
	}
}

public class test {
	   public static void main(String[] args) {

           Random random = new Random();

           NavigableSet<Integer> set = new TreeSet<>();

           int z1 = random.nextInt(10);

           int z2 = random.nextInt(10);

           while (set.size() < 5) {

                      set.add(random.nextInt(10));

           }

           set.subSet(z1, z2).remove(0);

}
	 

}
