package wbs.concurrent.misc;
/*
 * wiw CyclicBarrierThread aber
 * ohne hilf klasse 
 */
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

public class MoreCyclicBarrierDemo {
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(4);
		
		Runnable r = () -> {
			System.out.println(
					Thread.currentThread().getName()+ " waiting... ");
			try {
				barrier.await();
				System.out.println(
						Thread.currentThread().getName()+ " continue... ");
			}catch(Exception e) {
				
			}
		};
		
		Stream.of(r,r,r,r).forEach(t -> {
			try {
				Thread.sleep(1000);
				new Thread(t).start();
			}catch(InterruptedException e) {
				
			}
		});
	}
	

	

	
}
