package wbs.concurrent.executors;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;

public class PrimzahlZwillingeTaskResult {

        private BigInteger untergrenze;
        private BigInteger obergrenze;
        private Collection<BigInteger> twinPrimes = new HashSet<>();

        public PrimzahlZwillingeTaskResult(BigInteger untergrenze, BigInteger obergrenze,
                        Collection<BigInteger> twinPrimes) {
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

        public Collection<BigInteger> getTwinPrimes() {
                return twinPrimes;
        }
        
}
