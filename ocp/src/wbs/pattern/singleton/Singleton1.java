package wbs.pattern.singleton;

public class Singleton1 {
	// eager initialization
	// das singleton wird immer erzeugt, auch wenn es vielleicht nie gebraucht wird

	private static Singleton1 singleton1 = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		
		return singleton1;
	}
}


