package wbs.concurrent.variante;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * wir zerlegen ein grosses intervall von ganzen zahlen in mehrere teilintervalle.
 * für jedes dieser teilintervalle ermitteln wir alle primzahlzwillinge in tasks,
 * die durch einen thread-pool eines executorservice abgearbeitet werden.
 * 
 * dann fahren wir den executorservice runter, und geben im main-thread alle
 * gefundenen primzahlzwillinge aufsteigend sortiert aus.
 * 
 * name der klasse: PrimzahlZwillingeDemo
 */

public class PrimzahlZwillingeDemo2 {

        public static void main(String[] args) throws InterruptedException,
                ExecutionException {
                
                int poolSize = 5;

                ExecutorService executor = Executors.newFixedThreadPool(poolSize);

                BigInteger startWert = BigInteger.valueOf(1);
                BigInteger interval = BigInteger.valueOf(1000);
                int numOfIntervals = 20;
                BigInteger two = BigInteger.valueOf(2);

                PrimzahlZwillingeTask2 primeTask;

                Collection<PrimzahlZwillingeTask2> tasks = new HashSet<>();

                for (int i = 1; i <= numOfIntervals; i++) {
                        primeTask = new PrimzahlZwillingeTask2(startWert, startWert.add(
                                interval).subtract(two));
                        tasks.add(primeTask);
                        startWert = startWert.add(interval);
                }

                List<Future<PrimzahlZwillingeTaskResult2>> result = executor.invokeAll(
                        tasks);
                executor.shutdown();
                NavigableSet<TwinPrimesPair> twinPrimes = new TreeSet<>();
                for (Future<PrimzahlZwillingeTaskResult2> future : result) {
                        twinPrimes.addAll(future.get().getTwinPrimes());
                }
                for (TwinPrimesPair pair : twinPrimes) {
                        System.out.println(pair);
                }
        
        }
}
