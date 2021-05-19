package wbs.concurrent.locks_conditions;


import java.util.concurrent.ThreadLocalRandom;

public class Consumer<T> extends Thread {

        private SimpleQueue<T> finishedProducts;
        private int time;

        public Consumer(SimpleQueue<T> finishedProducts, int time) {
                this.finishedProducts = finishedProducts;
                this.time = time;
        }

        public void run() {

                while (true) {
                        T product = null;
                        try {
                                product = this.finishedProducts.take();
                        } catch (InterruptedException e) {
                                System.out.println("\tinterrupt consumer / take()");
                                break;
                        }
                        int delay = ThreadLocalRandom.current().nextInt(0, time);
                        System.out.printf("\tconsuming %s in %d milliseconds%n", product, delay);
                        try {
                                Thread.sleep(delay);
                        } catch (InterruptedException e) {
                                System.out.println("\tinterrupt consumer / sleep()");
                                break;
                        }
                        if (isInterrupted()) {
                                break;
                        }
                }
        }
}
