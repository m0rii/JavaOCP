//package wbs.ocp_tests_concurrency;
//
//import java.util.concurrent.CyclicBarrier;
//
////welche methode muss man überschreiben, wenn man RecursiceAction mit einer nicht abstrakten klasse erweitert?
////welche methode muss man überschreiben, wenn man RecursiceTask mit einer nicht abstrakten klasse erweitert?
//
////was ist die gemeinsame basisklasse von RecursiveAction und RecursiveTask?
////welche der folgenden behauptungen ist richtig?
////r wird nie ausgegeben
////r wird genau einmal ausgegeben
////r wird mehrmals ausgegeben
////die letzte ausgabe ist b
//class A041 extends Thread {
//	private final CyclicBarrier barrier;
//
//	public A041(CyclicBarrier barrier) {
//		this.barrier = barrier;
//	}
//
//	public void run() {
//		try {
//			System.out.println("r");
//			this.barrier.await();
//		} catch (Exception e) {
//		}
//	}
//}
//
//public class A04 {
//public static void main(String[] args) throws InterruptedException {
//Runnable r = () -> {
//try {
//System.out.println("b");
//} catch (Exception e) { // 
//}
//ocp concurrency [7]
//};
//CyclicBarrier barrier = new CyclicBarrier(4, r);
//A041 thread;
//for (int i = 0; i < 4; i++) {
//thread = new A041(barrier);
//thread.start();
//try {
//Thread.sleep(500);
//} catch (Exception e) {
//e.printStackTrace();
//}
//}
//}
//}