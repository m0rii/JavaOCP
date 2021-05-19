package wbs.stream.collectors;


import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap3Demo {

        public static void main(String[] args) {

                Stream<String> stream = Stream.of("x", "bb", "ccc", "x", "cCc", "BB");
                
                Function<String, String> keyMapper = String::toUpperCase;
                Function<String, Integer> valueMapper = String::length;
                BinaryOperator<Integer> mergeFunction = (i1, i2) -> i1 + i2;
                Supplier<Map<String, Integer>> supplier = TreeMap::new; // ye is a ba map dashte bashe treemap, hashmap ...
                
                Map<String, Integer> map = stream.collect(
                                Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));
//toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier)
                System.out.println(map);  // // {BB=4, CCC=6, X=2}
        }
}