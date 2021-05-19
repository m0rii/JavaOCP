package wbs.exception_assertions;

public class MyAutoCloseableDemo {
	public static void main(String[] args) {
		try (MyAutoCloseable_1 myAutoCloseable_1 = new MyAutoCloseable_1();
				MyAutoCloseable_2 myAutoCloseable_2 = new MyAutoCloseable_2()) {
			myAutoCloseable_1.m();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			System.out.println("in finally");
		}
	}
}
