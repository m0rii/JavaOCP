package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//exception?
//terminierung?
//ausgabe?
public class A08 {
	public static void main(String[] args) {
		Queue<String> queue1 = new LinkedList<String>();
		Queue<String> queue2 = new ArrayBlockingQueue<>(5); 
	// Creates an ArrayBlockingQueue with the given (fixed) capacity and default access policy

		for (int i = 0; i < 10; i++) {
			queue1.add(Integer.toString(i)); // boolean java.util.Queue.add(String e) 
	// returning true upon success and throwing an IllegalStateException if no space is currently available
			
			queue2.offer(Integer.toString(i)); // boolean java.util.Queue.offer(String e)
			// true if the element was added to this queue, else false and throwing an IllegalStateException if no space is currently available
			// Queue<String> queue2 = new ArrayBlockingQueue<>(0);  java.lang.IllegalArgumentException
			
		}
		System.out.println(queue1); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(queue2); // [0, 1, 2, 3, 4]
	}
}