package wbs.ocp_advanced_class_design;

//compilerfehler?
//ausgabe?
class A9Outer {
	int n = 4;

	class A9Inner {
		int n = 5;
		int m = A9Outer.this.n;
	}
}

public class A09 {
	public static void main(String[] args) {
		A9Outer.A9Inner ai = new A9Outer().new A9Inner();
		System.out.println(ai.n); // 5
		System.out.println(ai.m); // 4
	}
}