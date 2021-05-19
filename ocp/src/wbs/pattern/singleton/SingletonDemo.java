package wbs.pattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		Object obj = Singleton1.getInstance();
		Object obj2 = Singleton1.getInstance();
		System.out.println(obj == obj2);

		Singleton1 Singleton111 = Singleton1.getInstance();
		Singleton1 Singleton12 = Singleton1.getInstance();
		System.out.println(Singleton111 == Singleton12); // true , equals test na chon nemidoonim toosh chie bayad
															// bedoonim equals uberschreiben shode ya na
		/*
		 * deeper :
		 * https://www.javaworld.com/article/2074897/when-is-a-singleton-not-a-singleton-.html
		 */

	}

}
