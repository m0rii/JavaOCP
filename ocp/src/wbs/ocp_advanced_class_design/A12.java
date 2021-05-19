package wbs.ocp_advanced_class_design;

//compilerfehler?
//ausgabe?
enum A120 {
	ONE {
		public int m() {
			return ordinal() * 1;
		}
	},
	TWO {
		public int m() {
			return ordinal() * 2;
		}
	};

	public abstract int m();
}

public class A12 {
	public static void main(String[] args) {
		A120 a120 = A120.ONE;
		switch (a120) {
		case ONE:
			System.out.println(a120.m());
		case TWO:
			System.out.println(a120.m());
			break;
		}
	}
}