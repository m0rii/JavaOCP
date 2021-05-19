package wbs.playground.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class Consumer2<T> implements Runnable {

        private SimpleQueue2<T> finishedProducts;
        private Consumer<T> consumFunction;
        private int consumeDuration;
        private CountDownLatch latch;

        public Consumer2(SimpleQueue2<T> finishedProducts, Consumer<T> consumFunction, int consumDuration, CountDownLatch latch) {
                
                this.finishedProducts = finishedProducts;
                this.consumFunction = consumFunction;
                this.consumeDuration = consumDuration;
                this.latch = latch;
        }

        public void run() {
                while (true) {
                        T product;
                        try {
                                product = this.finishedProducts.take();
                                consumFunction.accept(product);
                                Thread.sleep(ThreadLocalRandom.current().nextInt(100,
                                                consumeDuration));
                                latch.countDown();
                        } catch (InterruptedException e) {
                                System.out.println("-- interrupt consumer");
                                break;
                        }
                }
        }
}
