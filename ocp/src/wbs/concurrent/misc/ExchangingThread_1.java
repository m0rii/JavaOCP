package wbs.concurrent.misc;

import java.util.concurrent.Exchanger;

class ExchangingThread_1 extends Thread {
	private final Exchanger<String> exchanger;

	public ExchangingThread_1(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void run() {
		String s1 = "One";
		String s2;
		try {
			sleep(1000);
		} catch (Exception e) {
// ignore
		}
		System.out.println(this.getName() + " exchanging " + s1);
		try {
			s2 = this.exchanger.exchange(s1);// from andere object anbietet
			System.out.println(this.getName() + " receiving " + s2);
		} catch (Exception e) {
// ignore
		}
	}
}
