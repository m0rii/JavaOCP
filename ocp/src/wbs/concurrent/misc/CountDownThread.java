package wbs.concurrent.misc;

import java.util.concurrent.CountDownLatch;

class CountDownThread extends Thread {
	private final CountDownLatch countDownLatch;

	public CountDownThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				sleep(500);
				System.out.println(this.getName() + " countDown");
				this.countDownLatch.countDown();
			} catch (Exception e) {
// ignore
			}
		}
	}
}


class WaitingThread extends Thread {
	private final CountDownLatch countDownLatch;

	public WaitingThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		System.out.println(this.getName() + " waiting");
		try {
			this.countDownLatch.await();
			System.out.println(this.getName() + " continues");
		} catch (Exception e) {
// ignore
		}
	}
}
