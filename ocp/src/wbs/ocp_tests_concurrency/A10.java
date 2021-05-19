package wbs.ocp_tests_concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//welche der folgenden behauptungen sind korrekt?
//der code compiliert nicht
//der code wirft eine exception
//der code terminiert nicht
//die ausgabe bei A kann nicht vorausgesagt werden
//die ausgabe bei B kann nicht vorausgesagt werden
public class A10 {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger ai = new AtomicInteger();
		Runnable runnable = () -> {
			for (int i = 0; i < 1_000; i++) {
				ai.incrementAndGet();
			}
		};
		Collection<Runnable> tasks = Arrays.asList(runnable, runnable, runnable);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		tasks.forEach(task -> executor.submit(task));
		executor.shutdown();
//A
		System.out.println(ai);
		executor.awaitTermination(10, TimeUnit.SECONDS);
//B
		System.out.println(ai);
	}
}