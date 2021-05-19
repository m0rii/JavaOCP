package wbs.stream.basic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class MatchDemo {
	
	// wir illustieren die foilgenden methoden von Strean :
	// allMatch , anyMatch , noneMatch`

	public static void main(String[] args) {
		
	System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().allMatch(a -> a instanceof Number)); // true	
	System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,"a").stream().allMatch(a -> a instanceof Number)); // false
	
	System.out.println(Arrays.asList("sdafas","sadf","lsdf","bb","a",1).stream().anyMatch(a -> a instanceof Number)); // true
	System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().anyMatch(a -> (a % 2 == 0))); // true

	System.out.println(Arrays.asList(1.2,2.2,3.2,4.2,5.2,6.2,7.2,8.2,9.2,"a").stream().noneMatch(a -> a instanceof Integer)); // true
	System.out.println(Arrays.asList(1,2,3,4,5,6,7,8,9,"aa").stream().noneMatch(a -> a instanceof String)); // false

	System.out.println("---------- kurs -----------");
    boolean b;

    b = Stream.generate(() -> Math.random()).limit(100)
                    .allMatch(x -> x < 1.0);
    System.out.println(b); // immer true

    b = Stream.iterate(2, n -> n * 2).limit(20).anyMatch(n -> n % 2 == 1); 
    System.out.println(b);  // immer false

    BigInteger TWO = BigInteger.valueOf(2);
    b = Stream.iterate(BigInteger.valueOf(11), bi -> bi.nextProbablePrime())
                    .limit(100)
                    .noneMatch(bi -> bi.divide(TWO).equals(BigInteger.ZERO));
    System.out.println(b);  // immer true

	}
	
	/*
	 * was sind hier terminal operations?
       allMatch , anyMatch , noneMatch -> ergebnis (ruckgabe type) ist boolean so terminal operation
       
         was sind hier intermediate operations?
        limit
        
         warum kann hier immer das ergebnis vorausgesagt werden?
         klar!

         was wäre das ergebnis, wenn man limit() aus den pipelines rausnehmen würde?
         ohne endlish ohne ergebnis liefert , unendlich stream -> allMatch and anyMatch and noneMatch 

        wie würde entsprechender code in imperativem stil aussehen?
``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
         werden hier immer a l l e elemente der streams verarbeitet?
         allMatch ja, anyMatch nein

        was ist der parameter von generate()?
         generate ist supplier
        
        was sind die parameter von iterate()? 
        strart wert ist int , zweite wert is unary operator
        
	 */

}
