package wbs.concurrent.more_fork_join;

/*
 * nach einer vorlage von Doug Lea
 * in http://gee.cs.oswego.edu/dl/cpjslides/fj.pdf
 * 
 * angepasst & erweitert für OCP prüfungszwecke von gz
 */

// zitat aus obiger quelle: "A useless algorithm, but easy to explain!"

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
class Fib extends RecursiveTask<Integer> {

	private Integer number;

	public Fib(int n) {
		number = n;
	}

	int seqFib(int n) {
		if (n <= 1)
			return n;
		else
			return seqFib(n - 1) + seqFib(n - 2);
	}

	public Integer compute() {
		return computeGut();
		// return computeBad();
	}

	public Integer computeGut() {
		int n = number;
		if (n <= 1) {
		} else if (n <= 12)
			number = seqFib(n);
		else {
			if (Math.random() > 0.5) {
				// gehupft
				Fib f1 = new Fib(n - 1);
				Fib f2 = new Fib(n - 2);
				f1.fork();
				number = f2.compute() + f1.join();
			} else {
				// ... wie gesprungen
				Fib f1 = new Fib(n - 1);
				f1.fork();
				Fib f2 = new Fib(n - 2);
				number = f2.compute() + f1.join();
			}
		}
		return number;
	}

	public Integer computeBad() {
		int n = number;
		if (n <= 1) {
		} else if (n <= 12)
			number = seqFib(n);
		else {
			Fib f1 = new Fib(n - 1);
			Fib f2 = new Fib(n - 2);
			f1.fork();
			number = f1.join() + f2.compute();
		}
		return number;
	}

	public static int fibonacciRecursive(int zahl) {
		return zahl <= 0 ? 0 : zahl == 1 ? 1 : fibonacciRecursive(zahl - 2) + fibonacciRecursive(zahl - 1);
	}

	public static int fibonacciIterativ(int zahl) {
		if (zahl == 1) {
			return 1;
		} else {
			int left = 0;
			int right = 1;
			for (int i = 2; i <= zahl; i++) {
				int tmp1 = right;
				int tmp2 = left + right;
				left = tmp1;
				right = tmp2;
			}
			return right;
		}
	}
}

public class FibonacciDougLeaModifiedDemo {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		long t1 = System.currentTimeMillis();
		Integer zahl = pool.invoke(new Fib(45));
		long t2 = System.currentTimeMillis();
		System.out.println("fork join");
		System.out.println(zahl);
		System.out.println(t2 - t1);

		System.out.println("-----------");
		t1 = System.currentTimeMillis();
		zahl = Fib.fibonacciRecursive(45);
		t2 = System.currentTimeMillis();
		System.out.println("rekursiv");
		System.out.println(zahl);
		System.out.println(t2 - t1);

		System.out.println("-----------");
		t1 = System.currentTimeMillis();
		zahl = Fib.fibonacciIterativ(45);
		t2 = System.currentTimeMillis();
		System.out.println("iterativ");
		System.out.println(zahl);
		System.out.println(t2 - t1);
	}
}
