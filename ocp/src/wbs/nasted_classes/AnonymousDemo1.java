package wbs.nasted_classes;

public class AnonymousDemo1 {
	class Base1 {
		Base1(String s) {
			System.out.println(s); // mori test
		}
	}

	public void m() {
		Base1 base1 = new Base1("abc") {
		};
		System.out.println(base1.getClass());
	}

	public static void main(String[] args) {
// class wbs.acd.anonymous.AnonymousDemo1$1
		new AnonymousDemo1().m();
	}
}