package wbs.ocp_tests_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

//welche der folgenden behauptungen sind richtig (jeweils unabhängig)?
//- aktivierung von A liefert einen compiler-fehler
//- aktivierung von B liefert einen compiler-fehler
//- aktivierung von C liefert einen compiler-fehler
//- aktivierung von D liefert als ausgabe true
//- aktivierung von E liefert als ausgabe true
//- aktivierung von F liefert als ausgabe true
public class A08 {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger ai = new AtomicInteger();
		int n = 0;
		Runnable runnable = () -> {
			for (int i = 0; i < 10_000_000; i++) {
				ai.incrementAndGet();
//A
// n++;  // Local variable n defined in an enclosing scope must be final or effectively final
//B
// ai++; atomic integer variable hat keine ++ compiler fehler
//C
//ai.addAndGet(); parametr mikhad in addAndGet() va khali compiler fehler
			}
		};
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
//D
System.out.println(ai.equals(20_000_000)); // kommt false
//E
// System.out.println(ai.get().equals(20_000_000)); // Cannot invoke equals(int) on the primitive type int
             // get methode return ein int zuruck
//F
System.out.println(ai.get() == 20_000_000); // kommt true
	}
}