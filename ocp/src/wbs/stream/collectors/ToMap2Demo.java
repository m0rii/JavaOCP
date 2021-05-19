package wbs.stream.collectors;


import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap2Demo {
        
        public static void main(String[] args) {
                
                Stream<String> stream = Stream.of("a", "bb", "ccc", "a", "ccc");
                
                Function<String, String> keyMapper = String::toUpperCase;
                Function<String, Integer> valueMapper = String::length;
                BinaryOperator<Integer> mergeFunction = (i1, i2) -> i1 + i2;
                
                Map<String, Integer> map = stream.collect(
                                Collectors.toMap(keyMapper, valueMapper, mergeFunction));
    // toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)    
                System.out.println(map);  // // {BB=2, A=2, CCC=3}
        }
}