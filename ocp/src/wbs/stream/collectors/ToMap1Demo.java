package wbs.stream.collectors;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap1Demo {
        
        public static void main(String[] args) {
                
                Stream<String> stream = Stream.of("a", "bb", "ccc");
                Map<String, Integer> map = stream.collect(
                                Collectors.toMap(s -> s.toUpperCase(), s -> s.length()));
                System.out.println(map);  // {BB=2, A=1, CCC=3}
                
        }
}