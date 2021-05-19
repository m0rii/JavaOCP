package wbs.playground.executor;


import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QueueExecutor<T1, T2> {
        
        static class Builder<U1, U2>{
                 
                QueueExecutor<U1, U2> instance = new QueueExecutor<>();
                
                public Builder(){}
                
                public Builder<U1, U2> output(Class<U2> resultType){
                        this.instance.setReturnType(resultType);
                        return this;
                }
                
                public Builder<U1, U2> input(List<U1> rawProduct) {
                        this.instance.producterLatch = new CountDownLatch(rawProduct.size());
                        this.instance.consumerLatch = new CountDownLatch(rawProduct.size());
                        this.instance.setInputValues(rawProduct);
                        return this;
                }
                
                public Builder<U1, U2> setInputQueueSize(int size) {
                        this.instance.RAW_PRODUCTS_QUEUE_SIZE = size;
                        return this;
                }
                
                public Builder<U1, U2> setProducers(int producers) {
                        this.instance.NUMBER_OF_PRODUCER_THREADS = producers;
                        return this;
                }
                
                public Builder<U1, U2> setProducerTask(Function<U1, U2> task) {
                        this.instance.setProducerTask(task);
                        return this;
                }
                
                public Builder<U1, U2> setConsumerTask(Consumer<U2> task) {
                        this.instance.setConsumerTask(task);
                        return this;
                }
                
                public Builder<U1, U2> setOutPutQueueSize(int size) {
                        this.instance.FINISHED_PRODUCTS_QUEUE_SIZE = size;
                        return this;
                }
                
                
                public Builder<U1, U2> setConsumers(int consumers) {
                        this.instance.NUMBER_OF_CONSUMERS_THREADS = consumers;
                        return this;
                }
                
                public QueueExecutor<U1, U2> run() {
                        
                        if (instance.refiner == null || instance.refiner == null)
                                throw new RuntimeException("must select consumer and supplier task");
                        instance.generateSupplier();
                        instance.generateConsumer();
                        this.instance.run();
                        return this.instance;
                }
                

        }
        

        private int RAW_PRODUCTS_QUEUE_SIZE = 100;
        private int FINISHED_PRODUCTS_QUEUE_SIZE = 5;
        private int NUMBER_OF_PRODUCER_THREADS = 6;
        private int NUMBER_OF_CONSUMERS_THREADS = 6;
        
        final private int MEAN_REFINE_DURATION = 500;
        final private int MEAN_CONSUME_DURATION = 1000;

                
        private CountDownLatch producterLatch; 
        private CountDownLatch consumerLatch;
                
        private BlockingQueue<T1> rawProducts;
        private SimpleQueue2<T2> finishedProducts;

        private Supplier<Producer2<T1, T2>> producerSupplier;
        private Supplier<Consumer2<T2>> consumerSupplier;

        private Function<T1, T2> refiner;
        private Consumer<T2> consumer;

        private List<Thread> producerThreads;
        private List<Thread> consumerThreads;
        
        private void setInputValues(List<T1> rawProduct) {
                this.rawProducts = new ArrayBlockingQueue<>(RAW_PRODUCTS_QUEUE_SIZE);
                this.rawProducts.addAll(rawProduct);
        }
        
        private void setReturnType(Class<T2> resultType) {
                this.finishedProducts = new SimpleArrayBlockingQueue2<>(resultType, FINISHED_PRODUCTS_QUEUE_SIZE);
        }

        private QueueExecutor() {
        }

        private void generateSupplier() {
                producerSupplier = () -> {
                        return new Producer2<>(rawProducts, finishedProducts, refiner, MEAN_REFINE_DURATION, producterLatch);
                };
        }
        
        @SuppressWarnings("unchecked")
        private void generateConsumer() {
                consumerSupplier = () -> {
                        try {
                                return (Consumer2<T2>) Class.forName(Consumer2.class.getName())
                                                                                        .getConstructor(Class.forName(SimpleQueue2.class.getName()),
                                                                                                                        Class.forName(Consumer.class.getName()), 
                                                                                                                        Integer.TYPE,
                                                                                                                        Class.forName(CountDownLatch.class.getName())
                                                                                                                        )
                                                                                        .newInstance(finishedProducts, consumer, MEAN_CONSUME_DURATION, consumerLatch);
                                
                        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                                        | InvocationTargetException | NoSuchMethodException | SecurityException
                                        | ClassNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                return null;
                                
                        }
                        
                
      };
        }

        private void setProducerTask(Function<T1, T2> task) {
                this.refiner = task;
        }
        
        private void setConsumerTask(Consumer<T2> consume) {
                this.consumer = consume;
        }
        

        public void shutDown() {
                this.interrupt();
        }

        private void run() {
            // start von produktion und verbrauch...
        // erzeugung der consumer threads

        consumerThreads = Stream.generate(consumerSupplier)
                        .limit(NUMBER_OF_CONSUMERS_THREADS).map(p -> new Thread((Runnable) p))
                        .collect(Collectors.toList());

        // erzeugung der producer-threads
        producerThreads = Stream.generate(producerSupplier)
                        .limit(NUMBER_OF_PRODUCER_THREADS).map(p -> new Thread(p))
                        .collect(Collectors.toList());

        // start der producer-threads
        producerThreads.forEach(t -> t.start());

        // start der consumer-threads
        consumerThreads.forEach(t -> t.start());
        
        // wait for all producers
        try {
                producterLatch.await(10, TimeUnit.SECONDS);
                        consumerLatch.await(15, TimeUnit.SECONDS);
                        interrupt();
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }
        
        private void interrupt() {
                
        producerThreads.forEach(t -> t.interrupt());
        consumerThreads.forEach(t -> t.interrupt());

        }

}
