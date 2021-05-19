package wbs.concurrent.misc;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCyclesDemo {

        static CyclicBarrier barrier;

        public static void main(String[] args)
                        throws InterruptedException {

                Runnable runnable = () -> {
                        try {
                                int n = barrier.await();
                                System.out.println(Thread.currentThread() + "(" + n
                                                + ")" + "running...");
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                                e.printStackTrace();
                        }
                };

                Runnable barrierAction = () -> System.out
                                .println("barrier action...");

                barrier = new CyclicBarrier(3, barrierAction);

                for (int n = 0; n < 5; n++) {
                        for (int i = 0; i < 3; i++) {
                                new Thread(runnable).start();
                                Thread.sleep(1000);
                        }
                }
        }
}
