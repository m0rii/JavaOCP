package wbs.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupingByDemo {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(Arrays.asList("eins","zwei","drei","vier","fuenf","sechs","sieben","acht","neun","zehn","elf","zwoelf","dreizehn","vierzehn","funfzehn"));
	Map<Integer,Set<String>> map =	SetUtil.groupingBy(set, s->s.length());
	System.out.println("------------gruppierung nach stringlange---------------");
	map.forEach((k,v) ->System.out.println( k + " -> " + v));
	
	
	System.out.println("----------grupierung nach anfangbuchstabe-----------------");
	Map<Character,Set<String>> map2 =	SetUtil.groupingBy(set, s->s.charAt(0));
	map2.forEach((k,v) ->System.out.println( k + " -> " + v));
	
	


	}

}
