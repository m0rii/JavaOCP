package wbs.concurrent.fork_join;

import java.math.BigInteger;

public class MutableBigInteger {
        
        private BigInteger bigInteger;

        public MutableBigInteger (BigInteger bigInteger) {
                this.bigInteger = bigInteger;
        }

        public synchronized BigInteger getBigInteger() {
                return bigInteger;
        }

        public synchronized void add(BigInteger summand) {
                bigInteger = bigInteger.add(summand);
        }
}
