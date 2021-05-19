package wbs.stream.parallel;


import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

public class PrimesDemo2 {

        static class Counter1 {
                int n;

                synchronized void inc() {
                        n++;
                }
        }

        static class Counter2 {
                int n;

                void inc() {
                        n++;
                }
        }

        public static void main(String[] args) {
                Counter1 counter1 = new Counter1();
                Counter2 counter2 = new Counter2();
                AtomicInteger ai = new AtomicInteger();
                long time1;
                long time2;

                System.out.println("--- counter1 ---");
                time1 = System.currentTimeMillis();
                LongStream.rangeClosed(2, 1_000_000).parallel().forEach(n -> {
                        if (BigInteger.valueOf(n).isProbablePrime(20)) {
                                counter1.inc();
                        }
                });
                System.out.println(counter1.n);
                time2 = System.currentTimeMillis();
                System.out.println(time2 - time1);

                System.out.println("--- counter2 ---");
                time1 = System.currentTimeMillis();
                LongStream.rangeClosed(2, 1_000_000).parallel().forEach(n -> {
                        if (BigInteger.valueOf(n).isProbablePrime(20)) {
                                counter2.inc();
                        }
                });
                System.out.println(counter2.n);
                time2 = System.currentTimeMillis();
                System.out.println(time2 - time1);

                System.out.println("--- atomic integer ---");
                time1 = System.currentTimeMillis();
                LongStream.rangeClosed(2, 1_000_000).parallel().forEach(n -> {
                        if (BigInteger.valueOf(n).isProbablePrime(20)) {
                                ai.getAndIncrement();
                        }
                });
                System.out.println(ai);
                time2 = System.currentTimeMillis();
                System.out.println(time2 - time1);
                
                System.out.println("--- filter ---");
                time1 = System.currentTimeMillis();
                long counter = LongStream.rangeClosed(2, 1_000_000).parallel()
                                .filter(n -> BigInteger.valueOf(n).isProbablePrime(20))
                                .count();
                time2 = System.currentTimeMillis();
                System.out.println(counter);
                System.out.println(time2 - time1);

                
                System.out.println("--- filter ---");
                time1 = System.currentTimeMillis();
                counter = LongStream.rangeClosed(2, 1_000_000).parallel()
                                .peek(n -> {
                                        if (n % 1000 == 0)
                                                System.out.println(Thread.currentThread());
                                }).filter(n -> BigInteger.valueOf(n).isProbablePrime(20))
                                .count();
                time2 = System.currentTimeMillis();
                System.out.println(counter);
                System.out.println(time2 - time1);
        }
        
        /*
         * was ermittelt der code? race condition meherere Thread

wo haben wir hier race conditions? parallel

wo haben wir hier side effects?2

wo kommt ein korrektes ergebnis raus?

würden bei einem nicht parallelen
stream alle ergebnisse korrekt sein?


         */
}




