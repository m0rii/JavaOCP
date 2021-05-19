package wbsocp_tests_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

//welche ausgabe erzeugt der folgende code?
public class A09 {
	public static void main(String[] args) {
		Supplier<AtomicInteger> supplier = AtomicInteger::new;
		List<AtomicInteger> list = new ArrayList<>();
		IntStream.rangeClosed(1, 5).forEach(n -> list.add(supplier.get()));
		list.forEach(ai -> ai.getAndIncrement()); 
		list.forEach(System.out::println); // 1 1 1 1 1
	}
}