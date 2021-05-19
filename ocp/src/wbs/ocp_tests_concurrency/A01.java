package wbs.ocp_tests_concurrency;

//geben sie für jeden der folgenden typen an, ob es sich um ein interface, eine konkrete, oder
//eine abstrakte klasse handelt. geben sie bitte zusätzlich an, ob es sich um einen generischen typ
//handelt.
//
//Executor -> RUNNUBLAE , submit mit 2 uberladung 
//ExecutorService
//Executors
//ForkJoinPool
//ForkJoinTask
//RecursiveAction
//RecursiveTask
//Future
//ScheduledExecutorService
//AbstractExecutorService
//ThreadPoolExecutor
//ThreadLocalRandom
//ScheduledThreadPoolExecutor
//welche der folgenden behauptungen sind richtig?
//der code wird nicht compiliert
//der code terminiert
//der code terminiert nicht
public class A01 extends Thread {
	public static void forever() {
		for (;;)
			;
	}

	public A01(Runnable r) {
		super(); // faghat Tread bedoone parametr ro seda mikone pas teminate mishe
	}

	public static void main(String[] args) {
		new A01(() -> {
			forever();
		}).start();

	}
}