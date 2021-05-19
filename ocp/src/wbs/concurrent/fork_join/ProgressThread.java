package wbs.concurrent.fork_join;

import java.math.BigInteger;

class ProgressThread extends Thread {

        private BigInteger interval;
        private MutableBigInteger mutableBigInteger;

        public ProgressThread(BigInteger interval,
                        MutableBigInteger mutableBigInteger) {
                this.interval = interval;
                this.mutableBigInteger = mutableBigInteger;
        }

        @Override
        public void run() {
                BigInteger quotient;
                BigInteger HUNDRED = BigInteger.valueOf(100);
                while (true) {
                        try {
                                Thread.sleep(1000);
                                quotient = mutableBigInteger.getBigInteger()
                                                .multiply(HUNDRED);

                                quotient = quotient.divide(interval);
                                System.out.printf("%,12d  %,12d (%3d%%)%n",
                                                mutableBigInteger.getBigInteger(), interval,
                                                quotient);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        if (mutableBigInteger.getBigInteger().equals(interval)) {
                                break;
                        }
                }
        }
}
