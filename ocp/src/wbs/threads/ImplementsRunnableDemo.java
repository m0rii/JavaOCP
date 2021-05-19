package wbs.threads;

//class ImplementsRunnable implements Runnable {
//	
//	public void run() {
//		System.out.println(Thread.currentThread());
//		
//	}
//
//}

public class ImplementsRunnableDemo {
	public static void main(String[] args) {
	//	ImplementsRunnable implementsRunnable = new ImplementsRunnable();
		//Thread thread = new Thread(implementsRunnable);
		//thread.start();
		//System.out.println(Thread.currentThread());
		 new Thread(()->System.out.println(Thread.currentThread())).start(); // lambda constructor Thread(Runnable target)
		 // hier gibt es 2 Thread new und main 
		System.out.println(Thread.currentThread());
	}
}
// toString() eines Threads gibt aus
// - den Namen
// - die Priorität
// - die ThreadGroup
// Ausgabe
// Thread[main,5,main]
// Thread[Thread-0,5,main]
