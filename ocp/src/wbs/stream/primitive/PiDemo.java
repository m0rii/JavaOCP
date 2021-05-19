package wbs.stream.primitive;

import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PiDemo {

	// wir geben die ersten 200 glieder der folgenden reihe aus.
	// 1 - 1/3 + 1/5 - 1/7 + 1/9 ...

	// am ende geben wir das vierfache der summe aus
	// (wir bekommen eine zahl, die nahe an pi liegt...).
	// https://de.wikipedia.org/wiki/Kreiszahl

	public static void main(String[] args) {

		int anzahl = 200;
		IntToDoubleFunction dividend = n -> n % 2 == 0 ? -1.0 : 1.0;
		IntUnaryOperator divisor = n -> n * 2 - 1;
		IntToDoubleFunction function = n -> dividend.applyAsDouble(n) / divisor.applyAsInt(n);
		DoubleSummaryStatistics ds1 = IntStream.rangeClosed(1, anzahl).mapToDouble(function)
				.peek(x -> System.out.printf("%7.6f%n" ,x)).summaryStatistics();

		System.out.println(ds1.getSum() * 4);

	}

}
