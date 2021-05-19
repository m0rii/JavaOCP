package wbs.stream.collectors;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy22Demo {
        public static void main(String[] args) {
                Map<Integer, String> map = Stream
                                .of("a", "b", "cc", "dd", "eeee", "ffff", "a", "ggg")
                                .collect(Collectors.groupingBy(s -> s.length(),
                                                Collectors.joining("+")));
                System.out.println(map);
                // {1=a+b+a, 2=cc+dd, 3=ggg, 4=eeee+ffff}
        }
}