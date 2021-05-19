package wbs.stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy3Demo {
        public static void main(String[] args) {
                Map<Integer, List<String>> map = Stream
                                .of("a", "b", "cc", "dd", "eeee", "fff", "d", "ggg")
                                .collect(Collectors.groupingBy(s -> s.length(), TreeMap::new,
                                                Collectors.toList()));
                System.out.println(map);
                // {1=[a, b, d], 2=[cc, dd], 3=[fff, ggg], 4=[eeee]}
                map = Stream.of("a", "b", "cc", "dd", "eeee", "fff", "d", "ggg")
                                .collect(Collectors.groupingBy(s -> s.length(),
                                                Collectors.toList()));
                System.out.println(map);
                // {1=[a, b, d], 2=[cc, dd], 3=[fff, ggg], 4=[eeee]}
        }
}

