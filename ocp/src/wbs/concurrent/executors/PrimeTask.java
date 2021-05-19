package wbs.concurrent.executors;


import java.math.BigInteger;
import java.util.concurrent.Callable;


import java.math.BigInteger;
import java.util.concurrent.Callable;

public class PrimeTask implements Callable<PrimeTaskResult> {

        private BigInteger untergrenze;
        private BigInteger obergrenze;

        public PrimeTask(BigInteger untergrenze, BigInteger obergrenze) {
                this.untergrenze = untergrenze;
                this.obergrenze = obergrenze;
        }

        @Override
        public PrimeTaskResult call() {
                // ohne optimierungen
                System.out.printf("%15s computing [%8s,%8s]%n", Thread.currentThread()
                        .getName(), untergrenze.toString(), obergrenze.toString());
                BigInteger anzahl = BigInteger.ZERO;
                BigInteger var = new BigInteger(untergrenze.toByteArray());
     
                for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
                        if (var.isProbablePrime(20)) {
                          
                           anzahl = anzahl.add(BigInteger.ONE);
                        }
                }
          
                return new PrimeTaskResult(untergrenze, obergrenze, anzahl);
            
        }
}