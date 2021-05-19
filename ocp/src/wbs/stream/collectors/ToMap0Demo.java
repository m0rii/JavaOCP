package wbs.stream.collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap0Demo {
        
        public static void main(String[] args) {
                Stream<String> stream = Stream.of("a", "bb", "ccc", "a");
                try {
                        Map<String, Integer> map = stream.collect(
                                        Collectors.toMap(s -> s.toUpperCase(), s -> s.length()));
                        System.out.println(map);
                } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());  // Duplicate key 1
                }
        }
}