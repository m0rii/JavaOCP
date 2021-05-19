//package wbs.ocp_tests_concurrency;
//
//import java.util.concurrent.Semaphore;
//
////was sind die wesentlichen unterschiede zwischen einer Queue und einer BlockingQueue?
////was sind die wesentlichen unterschiede zwischen einer Deque und einer BlockingDeque?
////nennen sie 3 klassen, die BlockingQueue implementieren.
////nennen sie 1 klasse, die BlockingDeque implementiert.
////welche der folgenden behauptungen ist richtig?
////der code terminiert
////der code terminiert nicht
//public class A05 {
//public static void main(String[] args) {
//Semaphore semaphore = new Semaphore(2);
//Runnable r1 = () -> {
//try {
//semaphore.acquire();
//Thread.sleep(500);
//semaphore.release();
//} catch (InterruptedException ie) {
//}
//};
//Runnable r2 = () -> {
//try {
//semaphore.tryAcquire(500, TimeUnit.MILLISECONDS);
//Thread.sleep(500);
//semaphore.release();
//} catch (InterruptedException ie) {
//ocp concurrency [8]
//}
//};
//Stream.of(r1, r1, r2).forEach(r -> new Thread(r).start());
//}
//}