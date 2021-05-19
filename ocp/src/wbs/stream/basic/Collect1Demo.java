package wbs.stream.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Collect1Demo { 
	
	/*
	 * wie oft wird der supplier aufgerufen? 
- bei einem sequentiellen stream? einmal
- bei einem parallelen stream?   mehrmals

wie muss man den code ändern,
um das herauszufinden?

wie ist die api-deklaration
im detail zu interpretieren?
was entspricht R, was entspricht T
	 */

        public static void main(String[] args) {

                Supplier<List<String>> supplier = ArrayList::new;

                BiConsumer<List<String>, String> accumulator = (l, s) -> {
                        System.out.printf("accumulator [%d, %s] %s%n", l.size(), s,
                                        Thread.currentThread());
                        l.add(s);
                };

                BiConsumer<List<String>, List<String>> combiner = (l1, l2) -> {
                        System.out.printf("combiner [%s, %s] %s%n", l1.size(), l2.size(),
                                        Thread.currentThread());
                        l1.addAll(l2);
                };

                long t1;
                long t2;
                List<String> result;

                // sequentiell
                t1 = System.currentTimeMillis();
                result = IntStream.rangeClosed(1, 1000).mapToObj(Integer::toOctalString)
                                .collect(supplier, accumulator, combiner);
                t2 = System.currentTimeMillis();
                System.out.println(t2 - t1);
                System.out.println(result);

                System.out.println("----------------");
                
                // parallel
                t1 = System.currentTimeMillis();
                result = IntStream.rangeClosed(1, 100).parallel()
                                .mapToObj(Integer::toOctalString)
                                .collect(supplier, accumulator, combiner);
                t2 = System.currentTimeMillis();
                System.out.println(t2 - t1);
                System.out.println(result);
        }
}
