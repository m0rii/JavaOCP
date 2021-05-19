package wbs.concurrent.variante;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;

public class PrimzahlZwillingeTaskResult2 {

        private BigInteger untergrenze;
        private BigInteger obergrenze;
        private Collection<TwinPrimesPair> twinPrimes = new HashSet<>();

        public PrimzahlZwillingeTaskResult2(BigInteger untergrenze, BigInteger obergrenze,
                        Collection<TwinPrimesPair> twinPrimes) {
                this.untergrenze = untergrenze;
                this.obergrenze = obergrenze;
                this.twinPrimes.addAll(twinPrimes);
        }

        public BigInteger getUntergrenze() {
                return untergrenze;
        }

        public BigInteger getObergrenze() {
                return obergrenze;
        }

        public Collection<TwinPrimesPair> getTwinPrimes() {
                return twinPrimes;
        }
        
}
