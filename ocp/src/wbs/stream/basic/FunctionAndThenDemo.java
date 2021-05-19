package wbs.stream.basic;
import java.util.function.Function;

public class FunctionAndThenDemo {

        public static void main(String[] args) {
                
                Function<Integer, String> f1 = i -> Integer.toBinaryString(i);
                Function<String, Integer> f2 = s -> s.length();
                
                Function<Integer, Integer> ff1 = f1.andThen(f2);
                Function<String, String> ff2 = f1.compose(f2);
             //   System.out.println(f1.apply(100));
              //  System.out.println(f2.apply("1100100"));
                System.out.println(ff1.apply(100)); 
                System.out.println(ff2.apply("yoohoo"));
        }
}