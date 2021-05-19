package wbs.concurrent.locks_conditions;


import java.util.concurrent.ThreadLocalRandom;

public class Consumer2<T> implements Runnable {

        private SimpleQueue2<T> finishedProducts;
        private java.util.function.Consumer<T> consumFunction;
        private int consumeDuration;

        public Consumer2(SimpleQueue2<T> finishedProducts,
                        java.util.function.Consumer<T> consumFunction, int consumDuration) {
                this.finishedProducts = finishedProducts;
                this.consumFunction = consumFunction;
                this.consumeDuration = consumDuration;
        }

        public void run() {
                while (true) {
                        T product;
                        try {
                                product = this.finishedProducts.take();
                                consumFunction.accept(product);
                                Thread.sleep(ThreadLocalRandom.current().nextInt(100,
                                                consumeDuration));

                        } catch (InterruptedException e) {
                                System.out.println("-- interrupt consumer");
                                break;
                        }
                }
        }
}
