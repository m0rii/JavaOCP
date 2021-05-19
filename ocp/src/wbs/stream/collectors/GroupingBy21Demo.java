package wbs.stream.collectors;


import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy21Demo {
        public static void main(String[] args) {
                Map<Integer, Set<String>> map = Stream
                                .of("a", "b", "cc", "dd", "eeee", "fff", "a", "ggg")
                                .collect(Collectors.groupingBy(s -> s.length(),
                                                Collectors.toSet()));
                System.out.println(map);
                // {1=[a, b], 2=[cc, dd], 3=[ggg, fff], 4=[eeee]}
        }
}