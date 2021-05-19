package wbs.concurrent.locks_conditions;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class Producer2<T1, T2> implements Runnable {

        private BlockingQueue<T1> rawProducts;
        protected SimpleQueue2<T2> finishedProducts;
        private Function<T1, T2> refiner;
        private int refineDuration;

        public Producer2(BlockingQueue<T1> rawProducts,
                        SimpleQueue2<T2> finishedProducts, Function<T1, T2> refiner,
                        int refineDuration) {
                this.rawProducts = rawProducts;
                this.finishedProducts = finishedProducts;
                this.refiner = refiner;
                this.refineDuration = refineDuration;
        }

        public void run() {

                T1 rawProduct;
                T2 finishedProduct;

                while (true) {
                        try {
                                rawProduct = rawProducts.take();
                                finishedProduct = refiner.apply(rawProduct);
                                Thread.sleep(ThreadLocalRandom.current().nextInt(100,
                                                refineDuration));
                                finishedProducts.put(finishedProduct);
                                System.out.printf(
                                                Thread.currentThread()
                                                                + " has produced (%s -> %s)[%s,%s]%n",
                                                rawProduct, finishedProduct, rawProducts.size(),
                                                finishedProducts.size());
                        } catch (InterruptedException e) {
                                System.out.println("-- interrupt producer");
                                break;
                        }
                }
        }
}