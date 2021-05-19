package wbs.ocp_advanced_class_design;

//compilerfehler?
public class A10 {
	class C {
//		public static int f(int i1, int i2) { // static methode kann nur in static class sein
//			return i1 + i2;
//		}
	}

	static class D {
		public static int f(int i1, int i2) {
			return i1 + i2;
		}
	}

	public static void main(String[] args) {
//		public class E { l // wir konne nicht lokale klasse als public declarieren
//			int n = 3;
//		}
		class F {
			int n = 3;
		}
	}
}