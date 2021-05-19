package wbs.threads;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

//wir ermitteln die anzahl aller primzahlen zwischen 1_000_000 und 2_000_000.
//wir verwenden dazu die methode nextProbablePrime() von BigInteger.

//variante 1: wir verwenden einen einzigen thread
//variante 2: wir verwenden zwei threads

//für das threadsichere inkrementieren des zählers verwenden wir die klasse AtomicInteger.

//wir vergleichen das laufzeitverhalten der beiden varianten.
    
	class Task implements Runnable{ // hilf klasse
		BigInteger from , to;
		AtomicInteger ai;
         public Task(BigInteger from , BigInteger to , AtomicInteger ai) {
        	 this.from = from;
        	 this.to = to;
        	 this.ai=ai;
         }
         
		@Override
		public void run() {
			for(BigInteger bi = from; bi.compareTo(to) <0;) {
				bi = bi.nextProbablePrime();
				if(bi.compareTo(to) <= 0) {
					ai.getAndIncrement();
				}
			}
			
		}
		
	}
	public class CompareTimesDemo {
		
     public static void main(String[] args) throws InterruptedException {
             
    	AtomicInteger ai = new AtomicInteger();
    	Task task = new Task(BigInteger.valueOf(1_000_000),
    			BigInteger.valueOf(2_000_000),ai);
    	Thread thread = new Thread(task);
    	
    	long t11;
    	long t12;
    	t11 = System.currentTimeMillis();
    	thread.start();
    	thread.join();
    	t12 = System.currentTimeMillis();
    	System.out.println("--- one thread ---");
    	System.out.println(ai);
    	System.out.println(t12 - t11);
    	
    	ai.set(0);
    	
    	Task task21 = new Task(BigInteger.valueOf(1_000_000), BigInteger.valueOf(1_500_000), ai);
    	Task task22 = new Task(BigInteger.valueOf(1_500_000), BigInteger.valueOf(2_000_000), ai);
    	Thread t21 = new Thread(task21);
    	Thread t22 = new Thread(task22);
    	t11 = System.currentTimeMillis();
    	t21.start();
    	t22.start();
    	t21.join();
    	t22.join();
    	t12 = System.currentTimeMillis();
    	System.out.println("--- two threads --");
    	System.out.println(ai);
    	System.out.println(t12 - t11);
    	
     }

	

}
