package wbs.stream.basic;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/*
 * wir erzeugen einen stream und filtern einige elemente aus (filter()) dann rufen rufen wir die methode max auf
 * und geben das maximm aus 
 * 
 * wir stellen sicher , dass zur compile-time ob der filter elemente des streams match oder nicht.
 * 
 * wir verwenden Optional
 */
public class MaxDemo {

	public static void main(String[] args) {

		Optional<Double> max = Stream.generate(()-> Math.random()).limit(10).filter(x -> x> 0.95).max(Comparator.naturalOrder());
		
		System.out.println(max.isPresent() ? max.get() : "no matches...");
		// waswaere ergebniss , wenn die nachstehende zeile ausgefuehrt werden wuerde?
		// System.out.println(max.get()); // java.util.NoSuchElementException: No value present

	}

}
