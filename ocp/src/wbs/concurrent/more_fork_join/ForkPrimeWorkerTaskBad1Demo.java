package wbs.concurrent.more_fork_join;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;


public class ForkPrimeWorkerTaskBad1Demo {
        public static void main(String[] args) {
                BigInteger untergrenze = BigInteger.ONE;
                BigInteger obergrenze = BigInteger.valueOf(10_000_000);
                BigInteger maxInterval = BigInteger.valueOf(100_000);
                long time_1;
                long time_2;
                int numberOfProcessors = Runtime.getRuntime().availableProcessors();
                
                
                ForkPrimeWorkerTaskBad1.setMaxInterval(maxInterval);
                ForkPrimeWorkerTaskBad1.setPrinting(true);
                ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
                time_1 = System.currentTimeMillis();
                BigInteger anzahl = pool
                                .invoke(new ForkPrimeWorkerTaskBad1(untergrenze, obergrenze));
                time_2 = System.currentTimeMillis();
                System.out.printf("[%,12d%,12d] -> %,12d%n", untergrenze, obergrenze,
                                anzahl);
                System.out.println("time: " + (time_2 - time_1));
        }
}
