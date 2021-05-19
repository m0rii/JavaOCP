package wbs.ocp_tests_concurrency;

//welche der folgenden behauptungen sind richtig?
//der code terminiert
//der code terminiert nicht -> jaa
public class A07 extends Thread {
	public static void forever() {
		for (;;)
			;
	}

	public A07(Runnable r) {
		super(r); // parametr dare va paramter dar ejra mishe
	}

	public static void main(String[] args) {
		new A07(() -> {
			forever();
		}).start();
	}
}