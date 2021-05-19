package wbs.concurrent.misc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		new CountDownThread(countDownLatch).start();
		new WaitingThread(countDownLatch).start();
		new WaitingThread(countDownLatch).start();
	}
}
