 package wbs.stream.basic;


import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {

        // wir erzeugen einen stream von Integer.
        // dann berechnen wir die summe aller elemente dieses streams. (a + b + c +
        // ... + x)
        // dann berechnen wir die differenz aller elemente dieses streams. (a - b -
        // c - d - ... - x)

        // wir verwenden die folgenden methoden von Stream;
        
        // Optional<T> reduce(BinaryOperator<T> accumulator)
        
        // reduce(U identity, BiFunction<U,? super T,U> accumulator,
        // BinaryOperator<U> combiner)

        // wir arbeiten mit einem sequentiellen und einem parallelen stream.
        
        // die addition ist assoziativ!
        // (1 + 2) + 3 = 6;
        // 1 + (2 + 3) = 6;
        // 1 + 2 + 3 = 6;
        
        // die subtraktion ist n i c h t assoziativ!
        // (1 - 2) - 3 = -4
        // 1 - (2 - 3) = 2
        // 1 - 2 - 3 = -4

        public static void main(String[] args) {
                
                // --- sequentielle streams ---
                
                Optional<Integer> o1 = Stream.iterate(1, n -> n + 1).limit(10).reduce((a, b) -> a + b);
                o1.ifPresent(System.out::println);  // 55 (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)
                
                Optional<Integer> o2 = Stream.iterate(1, n -> n + 1).limit(10).reduce((a, b) -> a - b);
                o2.ifPresent(System.out::println);  // -53 (1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10)
                int differenz = 1;
                for(int i = 2;i <= 10;i++) {
                        differenz -= i;
                }
                System.out.println(differenz);  // -53
                System.out.println(differenz == o2.get());  // true
                
                // --- parallele streams ---
                Integer n1 = Stream.iterate(1, n -> n + 1).limit(10)
                		                               // accumulator     //combiner
                                .parallel().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
                // das ergebnis ist korrekt. die addition ist assoziativ.
                System.out.println(n1);  // 55
                
                // das ergebnis ist nicht korrekt. die subtraktion ist nicht assoziativ.
                Integer n2 = Stream.iterate(1, n -> n + 1).limit(10)
                                .parallel().reduce(0, (a, b) -> a - b, (a, b) -> a - b);  // z.b. -5
                System.out.println(n2);
        }
}
/*
 * stream leer ist -> reduce produce null
 * 
 * 
 *  identity -> natural element
 *  identiy + assoziativitaet -> monoid
 *  
 * was ist die identity der addition?  
was ist die identity der multiplikation? 
was ist die identity der string-konkatenation?

was bedeutet "assoziativ"?
was bedeutet "identity"?

welcher der folgenden ausdrücke sind immer gleich?
(a + b) + c = a + (b + c) = a + b + c
(a *  b)  *  c = a * (b * c) = a * b *  c
(a - b) - c = a - (b - c) = a - b - c
(a / b) / c = a / (b / c) = a / b / c

(3-4)-5 => 6
3-(4-5) => 4

mit s als String =>Assosiative
(s1 + s2) + s3 = s1 + (s2 + s3) = s1 + s2 + s3
 *
 *  */
