package wbs.concurrent.locks_conditions;


import java.math.BigInteger;
import java.util.List;
import java.util.NavigableSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProducerConsumer2Demo {
	

        public static BigInteger fakultaet(int zahl)
                        throws IllegalArgumentException {
                if (zahl < 0) {
                        throw new IllegalArgumentException("bad argument...");
                }
                BigInteger result = BigInteger.ONE;
                for (; zahl > 1; zahl--) {
                        result = result.multiply(BigInteger.valueOf(zahl));
                }
                return result;
        }

        public static void main(String[] args) throws InterruptedException {

                final int RAW_PRODUCTS_QUEUE_SIZE = 100;
                final int FINISHED_PRODUCTS_QUEUE_SIZE = 5;
                final int NUMBER_OF_PRODUCER_THREADS = 6;
                final int NUMBER_OF_CONSUMERS_THREADS = 6;
                final int FROM_NUMBER = 10;
                final int TO_NUMBER = 50;
                final int MEAN_REFINE_DURATION = 500;
                final int MEAN_CONSUME_DURATION = 1000;
                final int MAIN_THREAD_WAITING_TIME_BEFORE_INTERRUPTING = 10000;
                final int MAIN_THREAD_WAITING_TIME_AFTER_INTERRUPTING = 2000;

                BlockingQueue<Integer> rawProducts = new ArrayBlockingQueue<>(
                                RAW_PRODUCTS_QUEUE_SIZE);

                SimpleQueue2<BigInteger> finishedProducts = new SimpleArrayBlockingQueue2<>(
                                BigInteger.class, FINISHED_PRODUCTS_QUEUE_SIZE);

                Function<Integer, BigInteger> refiner;
                java.util.function.Consumer<BigInteger> consumFunction;

                Supplier<Producer2<Integer, BigInteger>> producerSupplier;
                Supplier<Consumer2<BigInteger>> consumerSupplier;

                List<Thread> producerThreads;
                List<Thread> consumerThreads;
                
                // wir erweitern jetz aus welche primzahlen die consumer gefunden haben
               // kurs file finden ProducerConsumer3Demo
                
                consumFunction = bi -> {
                	
                        BigInteger plusOne = bi.add(BigInteger.ONE);
                        System.out.println(plusOne + " is probably prime: "
                                        + plusOne.isProbablePrime(20));
                };
                
                
                

                refiner = zahl -> fakultaet(zahl);

                producerSupplier = () -> {
                        return new Producer2<>(rawProducts, finishedProducts, refiner,
                                        MEAN_REFINE_DURATION);
                };

                consumerSupplier = () -> {
                        return new Consumer2<BigInteger>(finishedProducts, consumFunction,
                                        MEAN_CONSUME_DURATION);
                };

                // start von produktion und verbrauch...

                // erzeugung der roh-produkte
                IntStream.rangeClosed(FROM_NUMBER, TO_NUMBER).forEach(i -> rawProducts.add(i));
        
                // erzeugung der consumer-threads
                consumerThreads = Stream.generate(consumerSupplier)
                                .limit(NUMBER_OF_CONSUMERS_THREADS).map(p -> new Thread(p))
                                .collect(Collectors.toList());

                // erzeugung der producer-threads
                producerThreads = Stream.generate(producerSupplier)
                                .limit(NUMBER_OF_PRODUCER_THREADS).map(p -> new Thread(p))
                                .collect(Collectors.toList());

                // start der producer-threads
                producerThreads.forEach(t -> t.start());

                // start der consumer-threads
                consumerThreads.forEach(t -> t.start());

                Thread.sleep(MAIN_THREAD_WAITING_TIME_BEFORE_INTERRUPTING);

                System.out.println("--- interrupt() from main thread ---");

                producerThreads.forEach(t -> t.interrupt());
                consumerThreads.forEach(t -> t.interrupt());

                Thread.sleep(MAIN_THREAD_WAITING_TIME_AFTER_INTERRUPTING);

                System.out.println("--- finisH ---");
        }
        
        /*
         * was sind hier die "raw products"? IntStream ,Sind Integer  in BlockingQueue(ArrayBlockingQueue)
         was sind hier die "finished products" ? BigInteger 
         worin besteht das "refining"?  Falkultet in NumberUtil dann BigInteger
            worin besteht der "consum"? Consumer adiert 1 , kein teiler so = Primzahl;
         was für supplier werden hier verwendet? 
       was verbessert die lesbarkeit des codes (im vergleich zur gestrigen variante)?
         wie hoch ist der abstraktionsgrad?
         was bringen die abstraktionen? die wiederverwendsbarkeit code
         haben wir hier einen thread-pool und tasks? 
        was muss man tun, um raw products,
             refining, und consum auszutauschen?
           wie wurden producer und consumer geändert?
         wer hat welche verantwortlichkeiten?
            wie könnte der code ausgebaut werden?
         */

}


