package wbs.concurrent.misc;

import java.util.concurrent.CyclicBarrier;

class CyclicBarrierThread extends Thread {
	private final CyclicBarrier barrier;

	public CyclicBarrierThread(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		System.out.println(this.getName() + " waiting...");
		try {
			this.barrier.await();
			System.out.println(this.getName() + " continue...");
		} catch (Exception e) {
		}
	}
}

public class CyclicBarrierDemo {
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(4);
		CyclicBarrierThread thread;
		for (int i = 0; i < 4; i++) {
			thread = new CyclicBarrierThread(barrier);
			thread.start();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
