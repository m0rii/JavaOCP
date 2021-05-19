package wbs.ocp_tests_concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//welche der folgenden behauptungen sind richtig (unabhängig voneinander)
//- wenn zeile A aktiviert wird, gibt es eine exception
//- wenn zeile A aktiviert wird, gibt es einen compilerfehler
//- wenn zeile B aktiviert wird, terminiert das programm nicht
//- wenn zeile C aktiviert wird, gibt es einen compiler-fehler
public class A06 {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		queue.add("a");
		queue.add("b");
//A
// queue.add("c"); // exception , Unchecked exception IllegalStateException: Queue full
//B
 queue.offer("d"); // es ist offer und kein excewption , chon pore pas false mide va moshkeli pish nemiaD
//C
//queue.offer("e", 1000, TimeUnit.MILLISECONDS); checked ezception dare va throw nashode pas ciompiler fehler
	}
}