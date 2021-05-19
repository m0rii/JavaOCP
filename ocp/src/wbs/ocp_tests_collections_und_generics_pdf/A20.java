package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//welche ausgabe erzeugt der nachfolgende code?
public class A20 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Deque<Integer> deque = new LinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack); // [1, 2, 3]
		deque.addAll(stack);
		System.out.println(deque); // [1, 2, 3]
		System.out.println(deque.remove()); // 1
		// Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque

	}
}