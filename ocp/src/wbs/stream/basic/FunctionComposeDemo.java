package wbs.stream.basic;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.LongStream;

public class FunctionComposeDemo {

        public static void main(String[] args) {

                Function<Long, BigInteger> f1 = l -> BigInteger.valueOf(l);
                Function<BigInteger, Boolean> f2 = b -> b.isProbablePrime(20);

                Function<Long, Boolean> f = f2.compose(f1); // aval f1 ejra mishe bad natige f1 ke biginteger hast mire too f2

                LongStream.rangeClosed(100, 200).filter(l -> f.apply(l))
                                .forEach(System.out::println);
        }
}
