package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//nennen sie zwei klassen / interfaces, die die methoden push() und pop() deklarieren.
// stak und linked list

//was passiert, wenn der nachfolgende code ausgeführt wird?
public class A12 {
	public static void main(String[] args) {
		Queue<String> queue1 = new LinkedList<String>();
		Queue<String> queue2 = new ArrayBlockingQueue<>(5);
// Creates an ArrayBlockingQueue with the given (fixed) capacity and default access policy.
	//	Parameters:capacity the capacity of this queueThrows:IllegalArgumentException - if capacity < 1
		
		
		for (int i = 0; i < 10; i++) {
			queue1.add(Integer.toString(i));
			queue2.add(Integer.toString(i)); // java.lang.IllegalStateException: Queue full chon bala mahdood shode be 5
		}
	}
}
