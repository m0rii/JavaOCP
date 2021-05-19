package wbs.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class test {
	

	public static void main(String[] args) {
		/*
		 *  operatoren in atomicInteger : ++ , -- , += , -=
		 */

 
		
		AtomicInteger ai = new AtomicInteger();
		System.out.println(ai); //0
		ai.addAndGet(1);
		System.out.println(ai); // 1
		
		ai.accumulateAndGet(2, (a,b) -> a+b ); // IntBinaryOperator is functional interface and applyAsInt (left,right) return result
		
		System.out.println(ai); // 3 
		
		ai.decrementAndGet();
		System.out.println(ai); // karesh :--a  javab = 2
		
		ai.decrementAndGet(); // --ai;
		ai.getAndDecrement(); // ai--;
		System.out.println(ai);
	
		/*
		 *  *******kurs *******
		 *  ++ 
		 *  getAndIncrement() , incrementAndGet()
		 *  
		 *  --
		 *  getAndDecrement(), 	decrementAndGet()
		 *  +=
		 *  addAndGet() , getAndAdd()
		 *  
		 *  -=
		 *  addAndGet() , getAndAdd()
		 *  
		 */
		
		

	}

}
