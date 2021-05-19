package wbs.concurrent.misc;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/*
 * wie CountDownLatchDemo aber ohne hilfklasse 
 * also ohne WaitingfThread und ohne CountDownThread
 */

public class MoreCountDownLatchDemo {

        public static void main(String[] args) {
                
                CountDownLatch countDownLatch = new CountDownLatch(3);

                Runnable counter = () -> {
                        for (int i = 0; i < 3; i++) {
                                try {
                                        Thread.sleep(500);
                                        System.out.println(
                                                        Thread.currentThread().getName() + " countDown");
                                        countDownLatch.countDown();
                                } catch (Exception e) {
                                        // ignore
                                }
                        }
                };
                Runnable waiter = () -> {
                        System.out.println(Thread.currentThread().getName() + " waiting");
                        try {
                                countDownLatch.await();
                                System.out.println(
                                                Thread.currentThread().getName() + " continues");
                        } catch (Exception e) {
                                // ignore
                        }
                };

                Stream.of(counter, waiter, waiter).forEach(r -> new Thread(r).start());
        }
}


