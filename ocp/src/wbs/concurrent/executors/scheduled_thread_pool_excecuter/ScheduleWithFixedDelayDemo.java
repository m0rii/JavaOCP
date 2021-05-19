package wbs.concurrent.executors.scheduled_thread_pool_excecuter;

import java.time.LocalTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFixedDelayDemo {
	public static void main(String[] arg) throws InterruptedException {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
		Runnable command = () -> {
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		};
		executor.scheduleWithFixedDelay(command, 1000, 1000, TimeUnit.MILLISECONDS);
		Thread.sleep(20000);
		//executor.shutdownNow();
		System.out.println("end of main()");
	}
}
