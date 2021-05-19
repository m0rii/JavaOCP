package wbs.ocp_advanced_class_design;

//geben sie zwei beispiele für nested interfaces / nested classes im jdk
//compilerfehler? nein
//ausgabe? a
public class A03 {
	abstract class C {
		String m() {
			return "a";
		}
	}

	static void m(C c) {
		System.out.println(c.m());
	}

	public static void main(String[] args) {
		m(new A03().new C() {
		});
	}
}