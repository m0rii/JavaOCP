package wbs.concurrent.misc;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> exchanger = new Exchanger<String>(); // exchanger az ye type bayad bashe
		new ExchangingThread_1(exchanger).start();
		new ExchangingThread_2(exchanger).start();
	}
}
