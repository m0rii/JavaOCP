package wbs.concurrent.fork_join;


import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class ForkPrimeWorkerTask2Demo {
        
public static void main(String[] args) throws InterruptedException {
                BigInteger untergrenze = BigInteger.ONE;
                BigInteger obergrenze = BigInteger.valueOf(10_000_000);
                BigInteger maxInterval = BigInteger.valueOf(100_000);
                long time_1;
                long time_2;
                
                // new (bereits berechnet)
                MutableBigInteger mutableBigInteger = new MutableBigInteger(
                                BigInteger.ZERO);

                ForkPrimeWorkerTask2.setMaxInterval(maxInterval);
                ForkPrimeWorkerTask2.setSlow(false);
                ForkPrimeWorkerTask2.setPrinting(false);
                ForkJoinPool pool = new ForkJoinPool();
                time_1 = System.currentTimeMillis();
                
                // new (fortschrittsanzeige)
                ProgressThread progressThread = new ProgressThread(
                                obergrenze.subtract(untergrenze).add(BigInteger.ONE),
                                mutableBigInteger);

                progressThread.start();

                // modified (tasks bekommen eine referenz auf mutableBigInteger)
                // und aktualisieren in compute() den wert, wenn ein intervall berechnet wurde
                BigInteger anzahl = pool.invoke(new ForkPrimeWorkerTask2(untergrenze,
                        obergrenze, mutableBigInteger));
                progressThread.join();
                time_2 = System.currentTimeMillis();
                System.out.printf("[%,12d%,12d] -> %,12d%n", untergrenze, obergrenze,
                        anzahl);
                System.out.println("time: " + (time_2 - time_1));
        }
}
