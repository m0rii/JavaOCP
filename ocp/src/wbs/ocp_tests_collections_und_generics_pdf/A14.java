package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Deque;
import java.util.LinkedList;

//welche Queue hat eine Kapazität von 0?
// SynchronousQueue<E> not have any capacity not even of one!
// Exchanger

//welche Klasse verwendet diese Queue?
//

//welche ausgabe erzeugt der nachstehende code?
//

public class A14 {
	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(1);
		deque.push(2);
		deque.addLast(3);
		System.out.println(deque); //[2, 1, 3]
		
		System.out.println(deque.peek()); // 2 
		// in other words, the first element of this deque
		System.out.println(deque.peekFirst()); // 2 
		// Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
		
		System.out.println(deque.peekLast()); // 3
	// Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
		
		for (Integer i : deque) {
			System.out.print(i); // 213
		}
	}
}