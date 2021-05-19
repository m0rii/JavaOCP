package wbs.concurrent.misc;

import java.util.concurrent.Exchanger;

class ExchangingThread_2 extends Thread {
	private final Exchanger<String> exchanger;

	public ExchangingThread_2(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void run() {
		String s1 = "Two";
		String s2;
		try {
			sleep(2000);
		} catch (Exception e) {
// ignore
		}
		System.out.println(this.getName() + " exchanging " + s1);
		try {
			s2 = this.exchanger.exchange(s1);
			System.out.println(this.getName() + " receiving " + s2);
		} catch (Exception e) {
// ignore
		}
	}
}


