package wbs.concurrent.variante;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Callable;

public class PrimzahlZwillingeTask2
                implements Callable<PrimzahlZwillingeTaskResult2> {

        private BigInteger untergrenze;
        private BigInteger obergrenze;
        private Collection<TwinPrimesPair> twinPrimes = new HashSet<>();

        public PrimzahlZwillingeTask2(BigInteger untergrenze,
                        BigInteger obergrenze) {
                this.untergrenze = untergrenze;
                this.obergrenze = obergrenze;
        }

        @Override
        public PrimzahlZwillingeTaskResult2 call() {
                // ohne optimierungen
                BigInteger TWO = BigInteger.valueOf(2);
                BigInteger var = new BigInteger(untergrenze.toByteArray());
                for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
                        if (var.isProbablePrime(20) && var.add(TWO).isProbablePrime(20)) {
                                twinPrimes.add(new TwinPrimesPair(var, var.add(TWO)));
                        }
                }
                return new PrimzahlZwillingeTaskResult2(untergrenze, obergrenze,
                                twinPrimes);
        }
}
