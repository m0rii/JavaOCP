package wbs.ocp_advanced_class_design;

//compilerfehler?
//exception?
//ausgabe?
interface I111 {
	double distance(double x, double y);
}

public class A11 {
	public static void main(String[] args) {
		double p = 3;
		double[] da = { 1, 2, 3, 4, 5 };
		I111 i111 = new I111() {
			public double distance(double x, double y) {
				return Math.abs(x - y);
			}
		};
		for (double x : da) {
			System.out.println(i111.distance(p, x));
		}
	}
}