package wbs.concurrent.misc;
/*
 * diese klasse macht desshalbe wie SemaphoreDemo,
 * kommt aber ohne die hilfklasse SemaphoreUser aus
 */

import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class MoreSemaphoreDemo {

	public static void main(String[] args) {
		Semaphore machines = new Semaphore(2) ;
		
		Runnable r = ()->{
			try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting to access resource");
                machines.acquire();
                System.out.println(Thread.currentThread().getName()
                        + " accessing resource");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()
                        + " releasing resource");
                machines.release();
        } catch (InterruptedException ie) {
                // ignore
        }
		};
		
		  Stream.of("anna", "bernd", "chris", "dieter").forEach(s -> new Thread(
	              r , s).start());
		  
////////////// hamash baham in paein yeja
        Stream.of("anna", "bernd", "chris", "dieter").forEach(s -> new Thread(
                () -> {
                        try {
                                System.out.println(Thread.currentThread().getName()
                                        + " waiting to access resource");
                                machines.acquire();
                                System.out.println(Thread.currentThread().getName()
                                        + " accessing resource");
                                Thread.sleep(500);
                                System.out.println(Thread.currentThread().getName()
                                        + " releasing resource");
                                machines.release();
                        } catch (InterruptedException ie) {
                                // ignore
                        }
                }, s).start()); // Thread constructor Thread(Runnable target, String name)
	
		

	}

}
