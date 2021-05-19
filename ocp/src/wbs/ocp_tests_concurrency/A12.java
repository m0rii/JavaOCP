package wbs.ocp_tests_concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

//welche der folgenden methoden von BlockingQueue haben eine
//überladung, die mit einem timeout parametrisiert werden kann? offer() und poll()
//- take()
//- offer() ja mit timeout
//- add()
//- remove()
//- poll() ja mit timeout


//compilerfehler?
//exception?
//ausgabe 3000 ... 3000 ... 3000?
//ausgabe nicht voraussagbar?
public class A12 {
	public static void main(String[] args) throws Exception {
		AtomicInteger ai = new AtomicInteger();
		Callable<AtomicInteger> callable = () -> {
			for (int i = 0; i < 1000; i++) {
				ai.incrementAndGet();
			}
			return ai;
		};
		Collection<Callable<AtomicInteger>> tasks = Arrays.asList(callable, callable, callable);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Future<AtomicInteger>> futures = executor.invokeAll(tasks);
		for (Future<AtomicInteger> future : futures) {
			System.out.println(future.get().get());
		}
		executor.shutdown();
	}
}