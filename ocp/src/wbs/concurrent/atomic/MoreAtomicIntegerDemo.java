package wbs.concurrent.atomic;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * wir erzeugen mehrere threads, die in ihrer run-methode
 * ein-und dasselbe AtomicInteger-objekt 10_000_000 inkrementieren.
 * wenn alle threads fertig sind, geben wir den endwert aus.
 * wir verwenden einen executor-service. 
 */


public class MoreAtomicIntegerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		AtomicInteger ai = new AtomicInteger();
		
		Callable<Void> callable = () -> { // niazi nadarim chizi bargarde va rahesh ine ke type Void estefade konim
			for(int i =0 ; i < 10_000_000; i++) {
				ai.incrementAndGet();
			}
			return null;
		};
	
         LocalTime time1;
         Collection<Callable<Void>> tasks = Arrays.asList(callable,callable);
         ExecutorService executor = Executors.newFixedThreadPool(2);
         time1 = LocalTime.now();
         executor.invokeAll(tasks);
         
         System.out.println(ChronoUnit.MILLIS.between(time1 ,  LocalTime.now()));
         System.out.println(ai);
         executor.shutdown();
         
	}

}
