package wbs.threads.misc;
/*
 *  was unterscheidet einen thread, der
ein daemon-thread ist, von einem
thread, der kein daemon-thread ist?

wann terminiert ein java-prozess
n i c h t, auch wenn der main-thread beendet ist?

behält ein thread, der sich schlafen legt,
die monitor locks, die er bereits
besitzt? spielt die antwort auf diese frage
im vorliegenden code eine rolle?
 */

public class BlockedWaitingDemo {

	static class MyThread extends Thread {

		private Object o;

		public MyThread(Object o) {
			this.o = o;
		}

		@Override
		public void run() {
			synchronized (o) {
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (!interrupted()) {

			}
			try {
				Thread.sleep(1000); // Thread-0 TIMED_WAITING
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		MyThread t = new MyThread(o);
		System.out.println(t.getName() + " " + t.getState() );
		t.setDaemon(true);
		
		synchronized (o) {
			t.start();
			Thread.sleep(500); // aval inja blockech mikone va sleep mikhaboonash  Thread-0 BLOCKED
			System.out.println(t.getName() + " " + t.getState());
		}
		Thread.sleep(500);
		synchronized (o) {
			System.out.println(t.getName() + " " + t.getState());
			o.notifyAll(); // miad inja while not inteupted
		}
		Thread.sleep(500);
		System.out.println(t.getName() + " " + t.getState());
		t.interrupt();
		Thread.sleep(500);
		System.out.println(t.getName() + " " + t.getState());
		t.join(); // vaimise ta t1 tamoom mishe 
		System.out.println(t.getName() + " " + t.getState()); // Thread-0 TERMINATED

	}
}
