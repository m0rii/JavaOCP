package wbs.pattern.singleton;

public class Singleton2 {
	// lazy initialization
	// das singleton wird erst dann erzeugt, wenn es auch wirklich gebraucht wird,
	// unter umständen nie

	private static Singleton2 singleton2;

	private Singleton2() {

	}

	public static synchronized Singleton2 getInstance() {
		if (singleton2 == null) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}
