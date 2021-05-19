package wbs.ocp_tests_concurrency;

import java.util.concurrent.Exchanger;
import java.util.stream.Stream;

//welche überladungen (falls überhaupt welche) hat die methode execute() in Executor
//welche überladungen (falls überhaupt welche) hat die methode execute() in Executors
//welche überladungen (falls überhaupt welche) hat die methode execute() in ExecutorService
//
//welche überladungen (falls überhaupt welche) hat die methode submit() in Executor
//welche überladungen (falls überhaupt welche) hat die methode submit() in Executors
//welche überladungen (falls überhaupt welche) hat die methode submit() in ExecutorService
//welche der folgenden behauptungen sind richtig?
//der code compiliert nicht
//der code terminiert nicht
//der code gibt zwei zeilen aus und terminiert
public class A02 {
	public static void main(String[] args) {
		Exchanger<String> exc = new Exchanger<>();
		Runnable r1 = () -> {
			try {
				System.out.println(exc.exchange("a"));
			} catch (InterruptedException e) {
			}
		};
		Runnable r2 = () -> {
			try {
				System.out.println(exc.exchange("b"));
			} catch (InterruptedException e) {
			}
		};
		Stream.of(new Thread(r1), new Thread(r2)).forEach(t -> t.start());
	}
}
