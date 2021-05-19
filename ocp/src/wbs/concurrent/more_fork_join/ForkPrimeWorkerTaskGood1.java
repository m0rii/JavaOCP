package wbs.concurrent.more_fork_join;


//hauptlogik einer nicht degenerierten task
//(else- zweig)

//task1 = new Task(half-1)
//task1.fork()
//task2 = new Task(half-2)
//result2 = task2.compute();
//result1 = t1.join()
//kombiniere result1 und resul2

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class ForkPrimeWorkerTaskGood1 extends RecursiveTask<BigInteger> {

     private static final long serialVersionUID = 1L;
     private static final BigInteger TWO = BigInteger.valueOf(2);
     private final BigInteger untergrenze;
     private final BigInteger obergrenze;
     private static BigInteger maxInterval = BigInteger.valueOf(100_000);
     private static boolean isPrinting = true;

     public ForkPrimeWorkerTaskGood1(BigInteger untergrenze,
                     BigInteger obergrenze) {
             this.untergrenze = untergrenze;
             this.obergrenze = obergrenze;
     }

     public static void setMaxInterval(BigInteger maxInterval) {
             ForkPrimeWorkerTaskGood1.maxInterval = maxInterval;
     }

     public static void setPrinting(boolean isPrinting) {
             ForkPrimeWorkerTaskGood1.isPrinting = isPrinting;
     }

     @Override
     public BigInteger compute() {
             BigInteger interval = obergrenze.subtract(untergrenze);
             if (interval.compareTo(maxInterval) <= 0) {
                     // intervall ist klein genug. rechne.
                     BigInteger anzahl = BigInteger.ZERO;
                     BigInteger var = new BigInteger(untergrenze.toByteArray());
                     // ohne optimierung
                     for (; var.compareTo(obergrenze) <= 0; var = var
                                     .add(BigInteger.ONE)) {
                             if (var.isProbablePrime(40)) {
                                     anzahl = anzahl.add(BigInteger.ONE);
                             }
                     }
                     if (isPrinting) {
                             System.out.printf("%s comp [%,12d%,12d] -> %,12d%n",
                                             Thread.currentThread().getName(), untergrenze,
                                             obergrenze, anzahl);
                     }
                     return anzahl;
             } else {
                     BigInteger mid = (untergrenze.add(obergrenze)).divide(TWO);
                     if (isPrinting) {
                             System.out.printf("%s fork " + "[%,12d%,12d]<->[%,12d%,12d]%n",
                                             Thread.currentThread().getName(), untergrenze, mid,
                                             mid.add(BigInteger.ONE), obergrenze);
                     }
                     ForkPrimeWorkerTaskGood1 task1 = new ForkPrimeWorkerTaskGood1(
                                     untergrenze, mid);
                     task1.fork();
                     ForkPrimeWorkerTaskGood1 task2 = new ForkPrimeWorkerTaskGood1(
                                     mid.add(BigInteger.ONE), obergrenze);
                     BigInteger result2 = task2.compute();
                     BigInteger result1 = task1.join();
                     return result1.add(result2);
             }
     }
}
