package wbs.ocp_tests_concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//welche der folgenden behauptungen sind richtig
//compilerfehler
//der code terminiert und gibt 4000000 aus. -> das ist richtig , atomic integer is tread safe
//der code gibt 4000000 aus, terminiert aber nicht.
public class A09 {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger ai = new AtomicInteger();
		Callable<Void> callable = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				ai.incrementAndGet();
			}
			return null; // chon vioide bayad return null ro benevbisim
		};
		Collection<Callable<Void>> tasks = Arrays.asList(callable, callable, callable, callable);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.invokeAll(tasks);
		System.out.println(ai);
		executor.shutdown();
	}
}