package wbs.stream.basic;
//welche ausgabe erzeugt der folgende code?
//bitte d e t a i l l i e r t e analyse!

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapDemo {

     public static void main(String[] args) {
             
             String[] sa = { "eins und eins ist zwei", "anna und hanna",
                             "anna und manna und undine" };
             
             Function<String[] , Stream<String>> function =  sr-> Arrays.stream(sr);
             
             long n = Arrays.stream(sa) // stream von string
            		 .map(s -> s.split(" ")) // stream von array string
                             .flatMap(s -> Arrays.stream(s)) // stream von string  .flatMap(function)
                             .distinct()
                             .map(s -> s.toUpperCase())
                             .sorted()
                             .peek(System.out::println)
                             .count();
             
             System.out.println(n);
     };
}
