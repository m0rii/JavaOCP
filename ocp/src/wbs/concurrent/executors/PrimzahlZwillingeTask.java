package wbs.concurrent.executors;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Callable;



public class PrimzahlZwillingeTask implements Callable<PrimzahlZwillingeTaskResult> {

        private BigInteger untergrenze;
        private BigInteger obergrenze;
        private Collection<BigInteger> twinPrimes = new HashSet<>();

        public PrimzahlZwillingeTask(BigInteger untergrenze, BigInteger obergrenze) {
                this.untergrenze = untergrenze;
                this.obergrenze = obergrenze;
        }

        @Override
        public PrimzahlZwillingeTaskResult call() {
                // ohne optimierungen
                BigInteger TWO = BigInteger.valueOf(2);
                BigInteger var = new BigInteger(untergrenze.toByteArray());
                for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
                        if (var.isProbablePrime(20) && var.add(TWO).isProbablePrime(20)) {
                                twinPrimes.add(var);
                                twinPrimes.add(var.add(TWO));
                        }
                }
                return new PrimzahlZwillingeTaskResult(untergrenze, obergrenze, twinPrimes);
        }
}