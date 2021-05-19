package wbsocp_tests_Streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//welcher der nachfolgenden blöcke wirft eine exception? //A
//welcher der nachfolgenden blöcke führt zu einem compiler-fehler? C
//welcher der nachfolgenden blöcke wird korrekt compiliert und ausgeführt B
public class A11 {
public static void main(String[] args) {
//A                                                                 // liefert 1 or 0
Map<Integer, String> map1 = Stream.iterate(1, n -> n + 1).limit(10).map(n -> n % 2).
collect(Collectors.toMap(Function.identity(), n -> n + ""));
System.out.println(map1); // IllegalStateException: Duplicate key 1

//B
Map<Integer, String> map2 = Stream.iterate(1, n -> n + 1).limit(10).map(n -> n * 2)
.collect(Collectors.toMap(Function.identity(), n -> n + ""));
System.out.println(map2);

//C
//Map<Boolean, String> map3 = Stream.iterate(1, n -> n + 1).limit(10).map(n -> n * 2)
//.collect(Collectors.toMap(Function.identity(), n -> n + ""));
System.out.println(map2);
}
}