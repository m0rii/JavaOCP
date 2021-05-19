package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypeDemo {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List l2 = new ArrayList<>();
		l2 = l1;
		l2.add(1);
	    String  s = l1.get(0); // ClassCastException
		System.out.println(s);
	}
}