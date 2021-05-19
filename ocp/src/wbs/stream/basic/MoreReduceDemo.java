package wbs.stream.basic;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;


/*
 * wir erzeugen einen stream von strings.
 * die strings sind die oktalen darstellungen von zufallszahlen zwischen 0 und maxValue.
 * wir geben jeden string aus, und die gesamtlänge aller strings.
 * wir verwenden die methode reduce(identity, accumulator, combiner)
 * und einen parallelen stream.
 */

public class MoreReduceDemo {

      public static void main(String[] args) {

                // T: String
                // U: Integer

                Supplier<String> supplier;
                BiFunction<Integer, String, Integer> accumulator;
                BinaryOperator<Integer> combiner;
                Integer identity;
                int limit;
                int maxValue;
                Stream<String> stream;
                Random random;
                int summe;

                random = new Random();
                maxValue = 1000;
                identity = 0;
                limit = 10;
                supplier = () -> Integer.toOctalString(random.nextInt(maxValue));
                accumulator = (i, s) -> {
                        System.out.println("accumulator: " + Thread.currentThread());
                        return i + s.length();
                };
                combiner = (i1, i2) -> {
                        System.out.println("combiner: " + Thread.currentThread());
                        return i1 + i2;
                };

                stream = Stream.generate(supplier).limit(limit);

                System.out.println("--- sequentiell ---");
                summe = stream.peek(s -> System.out.println(s)).reduce(identity,
                                accumulator, combiner);

                System.out.println("--- parallel ---");
                stream = Stream.generate(supplier).limit(limit);
                summe = stream.parallel().peek(s -> System.out.println(s))
                                .reduce(identity, accumulator, combiner);

                System.out.println("summe: " + summe);
        }
      
}


