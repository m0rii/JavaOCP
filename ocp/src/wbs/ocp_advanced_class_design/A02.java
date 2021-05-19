package wbs.ocp_advanced_class_design;

//woran erkennt man eine static nested class?
//gibt es auch top level classes, die static sind?
//
public class A02 {
	abstract class C {
		String m() {
			return "a";
		}
	}

	static void m(C c) {
		System.out.println(c.m());
	}

	public static void main(String[] args) {
		// m(new C() {} ); geht nicht weil main methode static ist und klasse c nicht statioc ist
	}
}