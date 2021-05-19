package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//was passiert, wenn der nachfolgende code ausgeführt wird?
//terminiert der code?
//welche ausgabe wird gegebenenfalls erzeugt?
public class A13 {
	public static void main(String[] args) throws InterruptedException {
		Queue<String> queue1 = new LinkedList<String>();
		BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(5);
		for (int i = 0; i < 10; i++) {
			queue1.add(Integer.toString(i));
			queue2.offer(Integer.toString(i), 1, TimeUnit.SECONDS);	
			/* boolean java.util.concurrent.BlockingQueue.offer(String e, long timeout, TimeUnit unit) throws InterruptedException
			 *  System.out.println(queue2.offer(Integer.toString(i), 1, TimeUnit.SECONDS));
	    	 * true
             true
            true
            true
            true
            false
            false
             false
             false
             false
			*/
			/*
			 * Parameters:e the element to addtimeout how long to wait before giving up, in units of unitunit a 
			 * TimeUnit determining how to interpret the timeout parameter
			 * Returns:true if successful, or false if the specified waiting time elapses before space is available
			 */
		}
		System.out.println(queue1); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(queue2); // [0, 1, 2, 3, 4]
	}
}