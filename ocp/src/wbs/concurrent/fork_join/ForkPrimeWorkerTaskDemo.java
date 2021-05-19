package wbs.concurrent.fork_join;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
/*
 * wir bauen nun eine fortschrittsanzeige ein.
 * jede sekunde zeigen wir au dr console an,
 * wie viel prozent der arbeit getan ist
 */
public class ForkPrimeWorkerTaskDemo {
	public static void main(String[] args) {
		BigInteger untergrenze = BigInteger.ONE;
		BigInteger obergrenze = BigInteger.valueOf(10_000_000);
		BigInteger maxInterval = BigInteger.valueOf(100_000);
		long time_1;
		long time_2;
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		ForkPrimeWorkerTask.setMaxInterval(maxInterval);
		ForkPrimeWorkerTask.setSlow(false);
		ForkPrimeWorkerTask.setPrinting(true);
		ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
		time_1 = System.currentTimeMillis();
		BigInteger anzahl = pool.invoke(new ForkPrimeWorkerTask(untergrenze, obergrenze));
		time_2 = System.currentTimeMillis();
		System.out.printf("[%,12d%,12d] -> %,12d%n", untergrenze, obergrenze, anzahl);
		System.out.println("time: " + (time_2 - time_1));
	}
}