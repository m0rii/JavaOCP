package wbs.ocp_tests_concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//wenn der folgende code nicht nada ausgibt, dann gibt er [1, 2, 3, 4, 5, 11] aus?
public class A13 {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = Math.random() > 0.5 ? new CopyOnWriteArrayList<Integer>() : new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 5));
		Runnable reader = () -> {
			for (Integer i : list) { // java.util.ConcurrentModificationException
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable writer = () -> {
			try {
				Thread.sleep(100);
				list.add(11);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread readerThread = new Thread(reader);
		Thread writerThread = new Thread(writer);
		readerThread.start();
		writerThread.start();
		readerThread.join();
		writerThread.join();
		System.out.println(list.getClass() == CopyOnWriteArrayList.class ? list : "nada"); // nada
	}
}