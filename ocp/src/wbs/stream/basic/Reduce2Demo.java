package wbs.stream.basic;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce2Demo {

	// wir erzeugen einen stream von Integer.
	// dann berechnen wir die summe aller elemente dieses streams. (a + b + c +
	// ... + x)
	// dann berechnen wir die differenz aller elemente dieses streams. (a - b -
	// c - d - ... - x)

	// wir verwenden die folgenden methoden von Stream;

	// Optional<T> reduce(BinaryOperator<T> accumulator)

	// reduce(U identity, BiFunction<U,? super T,U> accumulator,
	// BinaryOperator<U> combiner)

	// wir arbeiten mit einem sequentiellen und einem parallelen stream.

	// die addition ist assoziativ!
	// (1 + 2) + 3 = 6;
	// 1 + (2 + 3) = 6;
	// 1 + 2 + 3 = 6;

	// die subtraktion ist n i c h t assoziativ!
	// (1 - 2) - 3 = -4
	// 1 - (2 - 3) = 2
	// 1 - 2 - 3 = -4

	public static void main(String[] args) {

		BinaryOperator<Integer> accumulatorPlus = (n1, n2) -> {
			System.out.println("accumulator + : " + Thread.currentThread());
			return n1 + n2;
		};

		BinaryOperator<Integer> combinerPlus = (n1, n2) -> {
			System.out.println("combiner + : " + Thread.currentThread());
			return n1 + n2;
		};

		BinaryOperator<Integer> accumulatorMinus = (n1, n2) -> {
			System.out.println("accumulator - : " + Thread.currentThread());
			return n1 - n2;
		};

		BinaryOperator<Integer> combinerMinus = (n1, n2) -> {
			System.out.println("combiner - : " + Thread.currentThread());
			return n1 - n2;
		};

		System.out.println("--- sequential ---");
		Optional<Integer> o1 = Stream.iterate(1, n -> n + 1).limit(10).reduce(accumulatorPlus);
		o1.ifPresent(n -> System.out.println("adition, sequentiell: " + n));

		Optional<Integer> o2 = Stream.iterate(1, n -> n + 1).limit(10).reduce(accumulatorMinus);
		o2.ifPresent(n -> System.out.println("subtraktion, sequentiell: " + n));
		int differenz = 1;
		for (int i = 2; i <= 10; i++) {
			differenz -= i;
		}
		System.out.println(differenz); // -53
		System.out.println(differenz == o2.get()); // true

		System.out.println("--- parallel ---");
		// --- parallele streams ---
		Integer n1 = Stream.iterate(1, n -> n + 1).limit(10).parallel().reduce(0, accumulatorPlus, combinerPlus);
		// das ergebnis ist korrekt. die addition ist assoziativ.
		System.out.println("adition, parallel: " + n1); // 55

		// das ergebnis ist nicht korrekt. die subtraktion ist nicht assoziativ.
		Integer n2 = Stream.iterate(1, n -> n + 1).limit(10).parallel().reduce(0, accumulatorMinus, combinerMinus); // z.b.
																													// -5
		System.out.println("subtraktion, parallel: " + n2);
		
//		// wir checken , ob bei einem sequentiellen stream der code des combiner ausgefuert
//		System.out.println("------------ sequentiell, dritte ueberladung , plus ----------------");
//		n1 = Stream.iterate(1, n -> n + 1).limit(10).parallel().reduce(0, accumulatorPlus, combinerPlus);
//		System.out.println("adition, parallel: " + n1); 
		
	}
}
