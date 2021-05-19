package wbs.generics;

import java.util.Arrays;

public class CartesischesProduktDemo {
      /*
       * wir illustieren die methode cartesischesProdukt() von Menge
       */
	public static void main(String[] args) {
		
	Menge<Integer> zahlen = new Menge<>(Arrays.asList(1,2,3));
	Menge<String> strings = new Menge<>(Arrays.asList("a","b","c","d"));
	
	Menge<Dupel<Integer, String>> cp = zahlen.cartesischesProdukt(strings);
	
	for(Dupel<Integer,String> dupel : cp) {
		System.out.println(dupel);
	}

	}

}
