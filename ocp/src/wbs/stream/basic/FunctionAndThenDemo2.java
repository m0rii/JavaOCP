package wbs.stream.basic;
import java.util.function.Function;

public class FunctionAndThenDemo2 {

        public static void main(String[] args) {
                Function<Integer, Integer> times2 = e -> e * 2;
                Function<Integer, Integer> squared = e -> e * e;
                System.out.println(times2.compose(squared).apply(4));                // Returns 32
                System.out.println(times2.andThen(squared).apply(4));                // Returns 64
                // andThen output: ist R    input eine Function von R nach V
                // default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
                
//                 Function<Integer, String> f1 = i -> Integer.toBinaryString(i);
//       Function<String, Integer> f2 = s -> s.length();
                
                 Function<Integer, String> f1 = i -> {
                         String str = Integer.toBinaryString(i);
                         System.out.println("-->f1 "+str);
                         return str;};
                         
       Function<String, Integer> f2 = s -> {
               Integer i2 = s.length();
               System.out.println("-->f2 "+i2);
               return i2; };
       
       Function<Integer, Integer> fThen = f1.andThen(f2);
       Function<String, String> fCompose = f1.compose(f2);
       
       System.out.println(fThen.apply(100));
       System.out.println(fCompose.apply("100"));
        }
}
