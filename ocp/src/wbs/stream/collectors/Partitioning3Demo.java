package wbs.stream.collectors;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class IntPair {
	int a;
	int b;

	public IntPair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "(" + a + "," + b + ")";
	}
	
}

/*
 * wir erzeugen einen stream mit 100 elementen vom typ IntPair. die felder a und
 * b eines IntPair sind jeweils zufallszahlen zwischen 2 und 1000. dann zerlegen
 * wir den stream mit partitioningBy() in 2 teilmengen. die erste teilmenge
 * enthält alle paare, deren zahlen einen gemeinsamen teiler haben. die zweite
 * teilmenge enthält alle paare, deren zahlen keinen gemeinsamen teiler haben.
 */

//bsp.:
//(222,40), (564,622), (528,93), (604,232), (327,477), (985,455),...  (gemeinsamer teiler)
//(682,687), (995,961), (953,602), (816,49), (288,881), (178,371),... (kein gemeinsamer teiler)

public class Partitioning3Demo {

	public static void main(String[] args) {
		
		Random random = new Random();
		/*
		 * int randomNumber = random.nextInt(max + 1 - min) + min;
             Note that the both lower and upper limits are inclusive.
		 */
		int size = 100;
		
		Supplier<IntPair> supllier = ()-> new IntPair(random.nextInt(999)+2,random.nextInt(999)+2);

		Predicate<IntPair> predicate = (p) -> {
			BigInteger gcd = BigInteger.valueOf(p.a).gcd(BigInteger.valueOf(p.b));
			return !gcd.equals(BigInteger.ONE);
		};
		
		BiConsumer<Boolean, List<IntPair>> consumer = (k,v) -> {
			 System.out.println(k + " -> " + v);
		 };

		Stream.generate(supllier).limit(size)
				.collect(Collectors.partitioningBy(predicate)).forEach(consumer);
		
	//	Map<Boolean,List<IntPair>> map = Stream.generate(supllier).limit(size)
	//			.collect(Collectors.partitioningBy(predicate)).forEach(consumer);
	//	System.out.println(map.get(true));
	//	System.out.println(map.get(false));
		

		 
		
		
		
		
	}
}