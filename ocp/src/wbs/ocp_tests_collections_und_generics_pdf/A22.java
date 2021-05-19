package wbs.ocp_tests_collections_und_generics_pdf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//was passiert, wenn der nachfolgende code ausgeführt wird?
//terminiert der code? nein , 
//welche ausgabe wird gegebenenfalls erzeugt?
// take methode ohne tyimeout parameter

public class A22 {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		Runnable r = () -> {
			try {
				String s = queue.take();
				System.out.println(s);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		};
		new Thread(r).start();
	}
}