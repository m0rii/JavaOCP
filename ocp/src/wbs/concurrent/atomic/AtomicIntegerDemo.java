package wbs.concurrent.atomic;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * wir erzeugen mehrere threads, die in ihrer run-methode
 * ein-und dasselbe AtomicInteger-objekt 10_000_000 inkrementieren.
 * wenn alle threads fertig sind, geben wir den endwert aus.
 * wir verwenden keinen executor-service. 
 */

public class AtomicIntegerDemo {
	
        public static void main(String[] args) throws InterruptedException {
        	
			AtomicInteger ai = new AtomicInteger();
			Runnable runnable = ()->{
				for(int i =0; i< 10_000_000;i++) {
					ai.incrementAndGet();
				}
			};
			
			Thread t1 = new Thread(runnable);
			Thread t2 = new Thread(runnable);
			
			LocalTime time1 = LocalTime.now();
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
			System.out.println(ChronoUnit.MILLIS.between(time1, LocalTime.now()));
			System.out.println(ai.get());
			// ai = null; //compiler fehler! warum? 
			// lambda zigriff efektiv final muss sein
			
			
		}
}


