package wbs.concurrent.executors.scheduled_thread_pool_excecuter;

import java.time.LocalTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateDemo {
	public static void main(String[] arg) throws InterruptedException {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
		Runnable command = () -> {
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(500); // Thread.sleep(2000) age bashe har 2 sanie por mishe vali algoritm motmaen mishe har kar tamoom she ta badi shorooshe
			} catch (InterruptedException e) {
			}
		};
		executor.scheduleAtFixedRate(command, 1000, 1000, TimeUnit.MILLISECONDS);
		Thread.sleep(20000); // bad az 20 sanie program payan mishe
		 executor.shutdownNow(); // ino comment konim excuter terminate nemishe va program haminjoor run mishe nonstop
		System.out.println("end of main()");
	}
}
