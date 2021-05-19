package wbs.concurrent.more_fork_join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// buch:
// 1: ForkJoinTask ist kein interface
// 2: i.d.r. erweitert man RecursiveTask oder RecursiveAction
//    und nicht direkt ForkJoinTask

class FindMinBad extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer[] elements;
	private int a;
	private int b;

	public FindMinBad(Integer[] elements, int a, int b) {
		this.elements = elements;
		this.a = a;
		this.b = b;
	}

	// compute(), degeneriert
	public Integer compute() {
		if ((b - a) < 2) {
			System.out.printf("directly: %s [a:%d b:%d] %n", Thread.currentThread(), a, b);
			return Math.min(elements[a], elements[b]);
		} else {
			int m = a + (b - a) / 2;
			System.out.printf("forking: %s [a:%d b:%d m:%d] %n", Thread.currentThread(), a, b, m);
			// System.out.println(a + "," + m + "," + b);
			FindMinBad t1 = new FindMinBad(elements, a, m);
			int result = t1.fork().join();
			return Math.min(new FindMinBad(elements, m, b).compute(), result);
		}
	}
}

public class A7_09BadDemo {

	public static void main(String[] args) {

		final int SIZE = 100_000;
		final int MIN = -128;
		Random random;
		Integer[] elements;

		long t1;
		long t2;

		elements = new Integer[SIZE];
		random = new Random();

		for (int i = 0; i < SIZE; i++) {
			elements[i] = random.nextInt(1000);
		}

		elements[random.nextInt(SIZE)] = MIN;

		t1 = System.currentTimeMillis();
		FindMinBad task = new FindMinBad(elements, 0, elements.length - 1);
		ForkJoinPool pool = new ForkJoinPool();
		Integer min = pool.invoke(task);
		t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println("Min: " + min);

	}
}
