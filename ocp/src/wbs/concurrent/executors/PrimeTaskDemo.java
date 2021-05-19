package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeTaskDemo {

        public static void main(String[] args) {

                int poolSize = 5;

              ExecutorService executor = Executors.newFixedThreadPool(poolSize);
         
          //      ExecutorService executor = Executors.newSingleThreadExecutor(); // yedoone Thread`

                BigInteger startWert = BigInteger.valueOf(1);
                BigInteger interval = BigInteger.valueOf(1_000_000);
                int numOfIntervals = 20; // 20 primtask durchlaufe bein1 ta 20 milion
                BigInteger two = BigInteger.valueOf(2);

                PrimeTask primeTask;

                Collection<PrimeTask> tasks = new HashSet<>();
                
                Comparator<Future<PrimeTaskResult>> cmp = (f1, f2) -> {
                        try {
                                return f1.get().getAnzahl().compareTo(f2.get().getAnzahl());
                        } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                };

                System.out.println("start of main");

                for (int i = 1; i <= numOfIntervals; i++) {
                        primeTask = new PrimeTask(startWert, startWert.add(interval)
                                .subtract(two));
                        tasks.add(primeTask);
                        startWert = startWert.add(interval);
                }
                    // lambda nemitoone checked ezception tolid kone
                try {
                        System.out.println("--- invokeAll() ---");
                        List<Future<PrimeTaskResult>> result = executor.invokeAll(tasks); // primtask implement callable pas okeye
                        System.out.println("--- invokeAll() returned ---");
                        executor.shutdown();
                        
                        result.sort(cmp);
                        
                        for (Future<PrimeTaskResult> future : result) {
                                System.out.printf("[%8d,%8d] -> %8d%n", future.get()
                                        .getUntergrenze(), future.get().getObergrenze(), future
                                                .get().getAnzahl());
                        }

                        System.out.println("end of main");
                        
                } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                }
                
                System.out.println("anzahl kernel oder cpus: " + Runtime.getRuntime().availableProcessors());
        }
}
