package wbsocp_tests_Streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

//erzeugt der nachstehende code eine ausgabe?
//falls ja: kann vorausgesagt werden, was angezeigt wird?
public class A12 {
	public static void main(String[] args) {
		Supplier<AtomicInteger> supplier = AtomicInteger::new;
		Stream<AtomicInteger> stream = Stream.generate(supplier).limit(5);
		stream.parallel().peek(ai -> ai.getAndIncrement()).forEach(System.out::println);
		// peek Returns:the new stream 1 1 1 1 1
	}
}
