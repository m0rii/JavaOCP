package wbs.threads;

import java.util.ArrayList;
import java.util.List;

class SynchronizedRaceCondition extends Thread {
	private List<Integer> li;

	public SynchronizedRaceCondition(List<Integer> li) {
		this.li = li;
	}

	public void run() {
		for (int i = 1; i <= 10000; i++) {
			synchronized (li) {
				li.add(i);
			}
		}
	}
}

public class RaceConditionSynchronizedDemo {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		SynchronizedRaceCondition src1 = new SynchronizedRaceCondition(li);
		SynchronizedRaceCondition src2 = new SynchronizedRaceCondition(li);
		src1.start();
		src2.start();
		try {
			src1.join();
			src2.join();
			System.out.println(li.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
