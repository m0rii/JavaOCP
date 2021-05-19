package wbs.playground.executor;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class QueueExecutorDemo {

    
    public static void main(String[] args) throws InterruptedException {
        
      List<Integer> data;
      QueueExecutor<Integer, BigInteger> service;
      Function<Integer, BigInteger> refiner;
      Consumer<BigInteger> consume;
      
        data = IntStream.range(1, 100).collect(ArrayList::new, (arr,z)-> arr.add(z), (arr,arr2)->arr.addAll(arr2));
        refiner = QueueExecutorDemo::fakultaet;
        consume = QueueExecutorDemo::isPrime;
        
        service = new QueueExecutor.Builder<Integer, BigInteger>()
                                     .input(data)
                                     .output(BigInteger.class)
                                     .setInputQueueSize(100)
                                     .setOutPutQueueSize(100)
                                     .setProducers(10)
                                     .setConsumers(20)
                                     .setProducerTask(refiner)
                                     .setConsumerTask(consume)
                                     .run();

    }


    public static void isPrime(BigInteger zahl) {
        BigInteger plusOne = zahl.add(BigInteger.ONE);
        System.out.println(plusOne + " is probably prime: " + plusOne.isProbablePrime(20));
    }
    
    
    
    public static BigInteger fakultaet(int zahl) throws IllegalArgumentException {
        
        if (zahl < 0) {
                throw new IllegalArgumentException("bad argument...");
        }
        
        BigInteger result = BigInteger.ONE;
        
        for (; zahl > 1; zahl--) {
                result = result.multiply(BigInteger.valueOf(zahl));
        }
        
        return result;
}


}
