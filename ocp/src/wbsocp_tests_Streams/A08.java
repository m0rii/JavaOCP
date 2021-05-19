package wbsocp_tests_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//welche ausgabe erzeugt der folgende code?
public class A08 {
	public static void main(String[] args) {
		Supplier<AtomicInteger> supplier = AtomicInteger::new;
		List<AtomicInteger> list = new ArrayList<>();
		IntStream.rangeClosed(1, 5).forEach(n -> list.add(supplier.get()));
		Stream.generate(supplier).peek(ai -> ai.getAndIncrement());
		list.forEach(ai -> System.out.println(ai.get())); // 0 0 0 0 0
	
	}
}